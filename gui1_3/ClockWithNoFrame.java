import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ClockWithNoFrame extends Window {
	private final int timerDelay    = 100;
	private final int timerInterval = 1000;
	private int x = 0;
	private int y = 0;
	private boolean leftPressed = false;
	private ClockWithNoFrame window;
	private PopupMenu popup = new PopupMenu();
	private MenuManager menuManager = new MenuManager();
	private TimePanel timePanel = new TimePanel();
	private Timer timer;
	private TimerTask task;
	
	public static void main(String[] args) {
		ClockWithNoFrame clock = new ClockWithNoFrame();
		clock.setLocation(40, 20);
		clock.setSize(10, 10);
		clock.setAlwaysOnTop(true);
		clock.show();
	}

	ClockWithNoFrame() throws HeadlessException {
		super(new Frame("ClockWithNoFrame"));
		// TODO Auto-generated constructor stub
		window = this;
		
		timePanel.addMouseListener(new MouseManager());
		timePanel.addMouseMotionListener(new MouseMotionManager());
		
		add(popup);
		popup.add(menuManager.createFileMenu());
		popup.add(menuManager.createViewMenu());
		

		timePanel.setFont(menuManager.getSelectedFont());
		timePanel.setForeground(menuManager.getSelectedForegroundColor());
		timePanel.setBackground(menuManager.getSelectedBackgroundColor());
		add(timePanel);
		timer = new Timer();
		task = new DigitalClockTask();
		timer.schedule(task, timerDelay, timerInterval);
	}

	class TimePanel extends Panel {
		private String text = "0000/00/00 00:00:00";
		public void setText(String text) {
			this.text = text;
		}
		
		public void paint(Graphics g) {			
			Insets insets = window.getInsets();
			FontMetrics fm = g.getFontMetrics();
			int sw = fm.stringWidth(text);
			int height = fm.getHeight();
			int descent = fm.getDescent();
			int x = insets.left + sw / 4;
			int y = (height - descent) * 3 / 2;

			window.setSize(insets.left + insets.right + sw * 3 / 2, insets.top + insets.bottom + height * 2);
			Dimension size = getSize();
			Image offImage = createImage(size.width, size.height);
			Graphics offGraphics = offImage.getGraphics(); 
			offGraphics.setColor(getForeground());
			offGraphics.drawString(text, x, y);

			g.drawImage(offImage, 0, 0, this);
		}
	}
	class MenuManager {
		private final String sizes[] = {"12", "14", "16", "18", "24", "30", "36", "48", "60"};

		private final Color[] COLORS = {
				Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
				Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
				Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
		};
		
		private final String[] COLORS_NAME = {
				"Black", "Blue", "Cyan", "Dark Gray",
				"Gray", "Green", "Light Gray", "Magenta",
				"Orange", "Pink", "Red", "White", "Yellow"
		};

		private int INITIAL_FONT= 0;
		private int INITIAL_SIZE = 5;
		private int INITIAL_FOREGROUND_COLOR = 0;
		private int INITIAL_BACKGROUND_COLOR = COLORS.length - 2;
		
		private RadioMenu font = null;
		private RadioMenu size = null;
		private RadioMenu foregroundColor = null;
		private RadioMenu backgroundColor = null;
		
		Menu createFileMenu() {
			Menu file = new Menu("File");
			MenuItem quitItem = new MenuItem("Quit");
			file.add(quitItem);
			quitItem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					dispose();
					System.exit(0);
				}
			});
			return file;
		}
		
		Menu createViewMenu() {
			Menu view = new Menu("View");
			view.add(createFontMenu());
			view.add(createSizeMenu());
			view.add(createForegroundColorMenu());
			view.add(createBackgroundColorMenu());
			return view;
		}
		
		private Menu createFontMenu() {
			if (font != null) {
				return font;
			}
			font = new RadioMenu("Font", true);
			String fontNames[] = getToolkit().getFontList();
			for (int i = 0; i < fontNames.length; i++) {
				CheckboxMenuItem item = new CheckboxMenuItem(fontNames[i]);
				font.add(item);
				item.addItemListener(new CheckboxMenuItemListener(font));
			}
			CheckboxMenuItem item = (CheckboxMenuItem)font.getItem(INITIAL_FONT);
			item.setState(true);
			return font;
		}
		
		private Menu createSizeMenu() {
			if (size != null) {
				return size;
			}
			size = new RadioMenu("Size", true);
			for (int i = 0; i < sizes.length; i++) {
				CheckboxMenuItem item = new CheckboxMenuItem(sizes[i]); 
				size.add(item);
				item.addItemListener(new CheckboxMenuItemListener(size));
			}
			CheckboxMenuItem item = (CheckboxMenuItem)size.getItem(INITIAL_SIZE);
			item.setState(true);
			return size;
		}
		
		private Menu createForegroundColorMenu() {
			if (foregroundColor != null) {
				return foregroundColor;
			}
			foregroundColor = new RadioMenu("Foreground Color", true);
			for (int i = 0; i < COLORS_NAME.length; i++) {
				CheckboxMenuItem item = new CheckboxMenuItem(COLORS_NAME[i].toString());
				foregroundColor.add(item);
				item.addItemListener(new CheckboxMenuItemListener(foregroundColor));
			}
			CheckboxMenuItem item = (CheckboxMenuItem)foregroundColor.getItem(INITIAL_FOREGROUND_COLOR);
			item.setState(true);
			return foregroundColor;
		}
		
		private Menu createBackgroundColorMenu() {
			if (backgroundColor != null) {
				return backgroundColor;
			}
			backgroundColor = new RadioMenu("Background Color", true);
			for (int i = 0; i < COLORS_NAME.length; i++) {
				CheckboxMenuItem item = new CheckboxMenuItem(COLORS_NAME[i].toString());
				backgroundColor.add(item);
				item.addItemListener(new CheckboxMenuItemListener(backgroundColor));
			}
			CheckboxMenuItem item = (CheckboxMenuItem)backgroundColor.getItem(INITIAL_BACKGROUND_COLOR);
			item.setState(true);
			return backgroundColor;
		}
		
		public Font getSelectedFont() {
			String family = font.getItem(getSelectedIndex(font)).getLabel();
			int fontSize = Integer.parseInt(size.getItem(getSelectedIndex(size)).getLabel());
			return new Font(family, 0, fontSize);
		}

		public Color getSelectedForegroundColor() {
			return COLORS[getSelectedIndex(foregroundColor)];
		}
		
		public Color getSelectedBackgroundColor() {
			return COLORS[getSelectedIndex(backgroundColor)];
		}
		
		private int getSelectedIndex(RadioMenu menu) {
			int index = 0;
			for (int i = 0; i < menu.countItems(); i++) {
				CheckboxMenuItem item = (CheckboxMenuItem)menu.getItem(i);
				if (item.getState()) {
					index = i;
				}
			}
			return index;
		}
	}
	
	class CheckboxMenuItemListener implements ItemListener {
		RadioMenu menu;
		
		CheckboxMenuItemListener(RadioMenu menu) {
			this.menu = menu;
		}
		
		public void itemStateChanged(ItemEvent event) {
			CheckboxMenuItem item = (CheckboxMenuItem)event.getSource();
			item.setState(true);
			menu.selectItem(item);
			timePanel.setFont(menuManager.getSelectedFont());
			timePanel.setForeground(menuManager.getSelectedForegroundColor());
			timePanel.setBackground(menuManager.getSelectedBackgroundColor());
		}
	}
	
	class MouseManager extends MouseAdapter {	
		public void mousePressed(MouseEvent event) {
			showPopup(event);
			if (event.getButton() != event.BUTTON1) {
				return;
			}
			x = event.getXOnScreen();
			y = event.getYOnScreen();
			leftPressed = true;
		}
		
		public void mouseReleased(MouseEvent event) {
			showPopup(event);
			if (event.getButton() != event.BUTTON1) {
				return;
			}
			leftPressed = false;
			Point p = window.getLocation();
			int newX = p.x + event.getXOnScreen() - x;
			int newY = p.y + event.getYOnScreen() - y;
			window.setLocation(newX, newY);
		}
		
		public void mouseClicked(MouseEvent event) {
			showPopup(event);
			if (event.getButton() != event.BUTTON3) {
				return;
			}
		}
		private void showPopup(MouseEvent event) {
			if (event.isPopupTrigger()) {
				popup.show(window, event.getX(), event.getY());
			}
		}
	}
	
	class MouseMotionManager extends MouseMotionAdapter {
		public void mouseDragged(MouseEvent event) {
			if (!leftPressed) {
				return;
			}
			Point p = window.getLocation();
			int newX = p.x + event.getXOnScreen() - x;
			int newY = p.y + event.getYOnScreen() - y;
			window.setLocation(newX, newY);

			x = event.getXOnScreen();
			y = event.getYOnScreen();
		}
	}
	
	class PopupActionListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			MenuItem menuItem = (MenuItem)event.getSource();
			System.out.println(menuItem);
		}
	}
	
	class DigitalClockTask extends TimerTask {
		@Override
		public void run() {
			timePanel.setText((new Date()).toLocaleString());
			timePanel.repaint();
		}		
	}
}
