import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.prefs.Preferences;
import java.util.prefs.BackingStoreException;

public class ClockWithMenu extends Frame {
	private final int timerDelay    = 100;
	private final int timerInterval = 1000;

	private ClockWithMenu clock;
	ClockPreference prefs = new ClockPreference();
	private MenuItem propertiesItem;
	private MenuItem quitItem;
	private MenuItemListener menuItemListener = new MenuItemListener();
	private FontManager fontManager = new FontManager();
	private TimePanel timePanel = new TimePanel();
	private Timer timer;
	private TimerTask task;

	public ClockWithMenu(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		clock = this;

		timer = new Timer();
		task = new DigitalClockTask();
		timer.schedule(task, timerDelay, timerInterval);
		
		MenuBar menubar = new MenuBar();

		Menu fileMenu = new Menu("File", true);
		Menu viewMenu = new Menu("View", true);

		fileMenu.add(quitItem = new MenuItem("Quit"));
		viewMenu.add(propertiesItem = new MenuItem("Properties"));

		menubar.add(fileMenu);		
		menubar.add(viewMenu);
		
		setMenuBar(menubar);
		
		quitItem.addActionListener(menuItemListener);
		propertiesItem.addActionListener(menuItemListener);
		
		timePanel.setFont(fontManager.getSelectedFont());
		timePanel.setForeground(fontManager.getSelectedTextColor());
		timePanel.setBackground(fontManager.getSelectedBackColor());
		add(timePanel);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				quit();
			}
		});	
	}
	
	public static void main(String args[]) {
		ClockWithMenu clock = new ClockWithMenu("ClockWithMenu");
		clock.setBounds(clock.prefs.getClockX(), clock.prefs.getClockY(), 200, 200);
		clock.show();
	}
	
	class TimePanel extends Panel {
		private String text = "0000/00/00 00:00:00";
		public void setText(String text) {
			this.text = text;
		}
		
		public void paint(Graphics g) {			
			Insets insets = clock.getInsets();
			FontMetrics fm = g.getFontMetrics();
			int sw = fm.stringWidth(text);
			int height = fm.getHeight();
			int descent = fm.getDescent();
			int x = insets.left + sw / 4;
			int y = (height - descent) * 3 / 2;

			clock.setSize(insets.left + insets.right + sw * 3 / 2, insets.top + insets.bottom + height * 2);
			Dimension size = getSize();
			Image offImage = createImage(size.width, size.height);
			Graphics offGraphics = offImage.getGraphics(); 
			offGraphics.setColor(getForeground());
			offGraphics.drawString(text, x, y);

			g.drawImage(offImage, 0, 0, this);
		}
	}
	
	void quit() {
		Point p = this.getLocationOnScreen();
		prefs.setClockPosition(p.x, p.y);
		prefs.setFont(fontManager.getFamilyChoice().getSelectedIndex(),
				fontManager.getSizeChoice().getSelectedIndex(),
				fontManager.getTextColorChoice().getSelectedIndex(),
				fontManager.getBackColorChoice().getSelectedIndex());
		prefs.save();
		clock.dispose();
		System.exit(0);		
	}
	class MenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MenuItem item = (MenuItem)arg0.getSource();
			
			if (item == quitItem) {
				quit();
			} else if (item == propertiesItem) {
				Dialog dialog = new PropertiesDialog();
				dialog.setBounds(clock.prefs.getDialogX(), clock.prefs.getDialogY(), 600, 200);
				dialog.show();
			}
		}
	}
	
	class PropertiesDialog extends Dialog {
		private Button okButton = new Button("OK");
		private Button cancellButton = new Button("Cancel");
		private GridBagLayout gbl = new GridBagLayout();
		private GridBagConstraints gbc = new GridBagConstraints();

		public PropertiesDialog() {
			super(new Frame(), "Properties", true);
			// TODO Auto-generated constructor stub
			setLayout(gbl);

			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx = 0;
			gbc.gridy = 0;
			gbc.gridwidth = 200;
			gbc.gridheight = 50;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			add(new Label("Font: "), gbc);

			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx += gbc.gridwidth;
			add(fontManager.getFamilyChoice(), gbc);

			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx = 0;
			gbc.gridy += gbc.gridheight;
			add(new Label("Size: "), gbc);
			
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx += gbc.gridwidth;
			add(fontManager.getSizeChoice(), gbc);

			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx = 0;
			gbc.gridy += gbc.gridheight;
			add(new Label("Foreground Color: "), gbc);
			
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx += gbc.gridwidth;
			add(fontManager.getTextColorChoice(), gbc);			

			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx = 0;
			gbc.gridy += gbc.gridheight;
			add(new Label("Background Color: "), gbc);
			
			gbc.anchor = GridBagConstraints.WEST;
			gbc.gridx += gbc.gridwidth;
			add(fontManager.getBackColorChoice(), gbc);

			//Panel buttonPanel = new Panel();
			//buttonPanel.add(okButton);
			//buttonPanel.add(cancellButton);
			
			//add(new FontPanel(), "Center");
			gbc.anchor = GridBagConstraints.EAST;
			gbc.gridx += 150;
			gbc.gridy += 50;
			gbc.weightx = 0.2;
			gbc.weighty = 0.2;
			add(okButton, gbc);
			
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.gridx += 50;
			add(cancellButton, gbc);
						
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					fontManager.backupIndexes();
					timePanel.setFont(fontManager.getSelectedFont());
					timePanel.setForeground(fontManager.getSelectedTextColor());
					timePanel.setBackground(fontManager.getSelectedBackColor());
					setDialogPosition();
					dispose();
				}
			});
			
			cancellButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					fontManager.rollbackIndexes();
					setDialogPosition();
					dispose();
				}
			});

			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent event) {
					fontManager.rollbackIndexes();
					setDialogPosition();
					dispose();
				}
			});
			
			pack();
		}
		
		void setDialogPosition() {
			Point p = this.getLocationOnScreen();
			prefs.setDialogPosition(p.x, p.y);
		}
	}
	
	class FontManager {
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

		private Choice familyChoice = new Choice();
		private Choice sizeChoice = new Choice();
		private Choice textColorChoice = new Choice();
		private Choice backColorChoice = new Choice();
		
		private int currentFamily = prefs.getFont();
		private int currentSize = prefs.getSize();
		private int currentTextColor = prefs.getForegroundColor();
		private int currentBackColor = prefs.getBackgroundColor();

		public FontManager() {
			populateFamilies();
			populateSizes();
			populateTextColors();
			populateBackColors();
			
			rollbackIndexes();
		}
		
		public Font getSelectedFont() {
			String family = familyChoice.getSelectedItem();
			int size = Integer.parseInt(sizeChoice.getSelectedItem());
			return new Font(family, 0, size);
		}

		public Color getSelectedTextColor() {
			return COLORS[currentTextColor];
		}
		
		public Color getSelectedBackColor() {
			return COLORS[currentBackColor];
		}
		
		private void populateFamilies() {
			String fontNames[] = getToolkit().getFontList();
			for (int i = 0; i < fontNames.length; i++) {
				familyChoice.add(fontNames[i]);
			}
		}
		
		private void populateSizes() {
			String sizes[] = {"12", "14", "16", "18", "24", "30", "36", "48", "60"};
			
			for (int i = 0; i < sizes.length; i++) {
				sizeChoice.add(sizes[i]);
			}
		}
		
		private void populateTextColors() {
			for (int i = 0; i < COLORS_NAME.length; i++) {
				textColorChoice.add(COLORS_NAME[i].toString());
			}
		}
		
		private void populateBackColors() {
			for (int i = 0; i < COLORS_NAME.length; i++) {
				backColorChoice.add(COLORS_NAME[i].toString());
			}			
		}
		
		public Choice getFamilyChoice() {
			return familyChoice;
		}
		
		public Choice getSizeChoice() {
			return sizeChoice;
		}
		
		public Choice getTextColorChoice() {
			return textColorChoice;
		}
		
		public Choice getBackColorChoice() {
			return backColorChoice;
		}
		
		private void backupIndexes() {
			currentFamily = familyChoice.getSelectedIndex();
			currentSize = sizeChoice.getSelectedIndex();
			currentTextColor = textColorChoice.getSelectedIndex();
			currentBackColor = backColorChoice.getSelectedIndex();
		}
		
		private void rollbackIndexes() {
			familyChoice.select(currentFamily);
			sizeChoice.select(currentSize);
			textColorChoice.select(currentTextColor);
			backColorChoice.select(currentBackColor);
		}
	}
	
	class DigitalClockTask extends TimerTask {
		@Override
		public void run() {
			timePanel.setText((new Date()).toLocaleString());
			timePanel.repaint();
		}		
	}
	
	class ClockPreference {
		private Preferences prefs = Preferences.userNodeForPackage(this.getClass());
		private int[] data = {100, 100, 200, 200, 0, 5, 0, 11};
		private String keyBase = ".yuusuke.oy.ohta";
		private String[] keys = {
				"clock.x", "clock.y", "dialog.x", "dialog.y",
				"font", "size", "foreground.color", "background.color"
		};
		{
			for (int i = 0; i < keys.length; i++) {
				keys[i] += keyBase;
			}
		}
		private final int CLOCK_X          = 0; 
		private final int CLOCK_Y          = 1; 
		private final int DIALOG_X         = 2; 
		private final int DIALOG_Y         = 3; 
		private final int FONT             = 4; 
		private final int SIZE             = 5; 
		private final int FOREGROUND_COLOR = 6; 
		private final int BACKGROUND_COLOR = 7; 
		
		ClockPreference() {
			load();
		}
		
		void setClockPosition(int x, int y) {
			data[CLOCK_X] = x;
			data[CLOCK_Y] = y;
		}
		
		void setDialogPosition(int x, int y) {
			data[DIALOG_X] = x;
			data[DIALOG_Y] = y;
		}
		
		void setFont(int font, int size, int foregroundColor, int backgroundColor) {
			data[FONT] = font;
			data[SIZE] = size;
			data[FOREGROUND_COLOR] = foregroundColor;
			data[BACKGROUND_COLOR] = backgroundColor;
		}
		
		void save() {
			for(int i = 0; i < keys.length; i++) {
				prefs.putInt(keys[i], data[i]);
			}
		}
		
		private void load() {
			for(int i = 0; i < keys.length; i++) {
				data[i] = prefs.getInt(keys[i], data[i]);
			}
		}
		
		int getClockX() {
			return data[CLOCK_X];
		}
		
		int getClockY() {
			return data[CLOCK_Y];
		}
		
		int getDialogX() {
			return data[DIALOG_X];
		}
		
		int getDialogY() {
			return data[DIALOG_Y];
		}
		
		int getFont() {
			return data[FONT];
		}
		
		int getSize() {
			return data[SIZE];
		}
		
		int getForegroundColor() {
			return data[FOREGROUND_COLOR];
		}
		
		int getBackgroundColor() {
			return data[BACKGROUND_COLOR];
		}
	}
	
}
