import java.awt.*;
import java.awt.event.*;

public class ClockWithMenu extends Frame {
	private Frame self;
	private MenuItem propertiesItem;
	private MenuItem quitItem;
	private MenuItemListener menuItemListener = new MenuItemListener();
	private FontManager fontManager = new FontManager();
	private TimePanel timePanel = new TimePanel();
	
	public ClockWithMenu(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		self = this;
		
		MenuBar menubar = new MenuBar();

		Menu fileMenu = new Menu("File", true);
		Menu viewMenu = new Menu("View", true);

		fileMenu.add(quitItem = new MenuItem("Quit"));
		viewMenu.add(propertiesItem = new MenuItem("Propeties"));

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
				dispose();
				System.exit(0);
			}
		});
	}
	
	public static void main(String args[]) {
		ClockWithMenu clock = new ClockWithMenu("ClockWithMenu");
		clock.setBounds(100, 100, 200, 200);
		clock.show();
	}
	
	class TimePanel extends Panel {
		private String text = "2014/02/24 19:56:29";
		public void setText(String text) {
			this.text = text;
		}
		
		public void paint(Graphics g) {
			Insets insets = self.getInsets();
			FontMetrics fm = g.getFontMetrics();
			int sw = fm.stringWidth(text);
			int height = fm.getHeight();
			int descent = fm.getDescent();
			int x = insets.left + sw / 4;
			int y = (height - descent) * 3 / 2;
			
			self.setSize(insets.left + insets.right + sw * 3 / 2, insets.top + insets.bottom + height * 2);
			System.out.println("sw=" + sw);
			System.out.println("text=" + text);
			System.out.println("sw=" + sw);
			System.out.println("height=" + height);
			System.out.println("descent=" + descent);

			g.setColor(getForeground());
			g.drawString(text, x, y);
		}
	}
	
	class MenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			MenuItem item = (MenuItem)arg0.getSource();
			System.out.println(item.getLabel());
			
			if (item == quitItem) {
				dispose();
				System.exit(0);
			} else if (item == propertiesItem) {
				Dialog dialog = new PropertiesDialog();
				dialog.setBounds(200, 200, 600, 200);
				dialog.show();
			}
		}
	}
	
	class PropertiesDialog extends Dialog {
		Button okButton = new Button("OK");
		Button cancellButton = new Button("Cancel");
		
		public PropertiesDialog() {
			super(new Frame(), "Properties", true);
			// TODO Auto-generated constructor stub
			System.out.println("dialog");
			
			Panel buttonPanel = new Panel();
			buttonPanel.add(okButton);
			buttonPanel.add(cancellButton);
			
			add(new FontPanel(), "Center");
			add(buttonPanel, "South");
			
			okButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					fontManager.backupIndexes();
					timePanel.setFont(fontManager.getSelectedFont());
					timePanel.setForeground(fontManager.getSelectedTextColor());
					timePanel.setBackground(fontManager.getSelectedBackColor());
					dispose();
				}
			});
			
			cancellButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					fontManager.rollbackIndexes();
					dispose();
				}
			});
			
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent event) {
					fontManager.rollbackIndexes();
					dispose();
				}
			});
			
			pack();
		}
	}
	
	class FontPanel extends Panel {
		public FontPanel() {
			add(fontManager.getFamilyList());
			add(fontManager.getSizeList());			
			add(fontManager.getTextColorList());			
			add(fontManager.getBackColorList());
		}
	}
	
	class FontManager {
		private final Color[] COLORS = {
				Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
				Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
				Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
		};
		
		private final String[] COLORS_NAME = {
				"black", "blue", "cyan", "dark_gray",
				"gray", "green", "light_gray", "magenta",
				"orange", "pink", "red", "white", "yellow"
		};

		private List familyList = new List();
		private List sizeList = new List();
		private List textColorList = new List();
		private List backColorList = new List();
		
		private int currentFamily = 0;
		private int currentSize = 5;
		private int currentTextColor = 0;
		private int currentBackColor = COLORS.length - 2;

		public FontManager() {
			populateFamilies();
			populateSizes();
			populateTextColors();
			populateBackColors();
			
			rollbackIndexes();
		}
		
		public Font getSelectedFont() {
			String family = familyList.getSelectedItem();
			int size = Integer.parseInt(sizeList.getSelectedItem());
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
				familyList.add(fontNames[i]);
			}
		}
		
		private void populateSizes() {
			String sizes[] = {"12", "14", "16", "18", "24", "30", "36", "48", "60"};
			
			for (int i = 0; i < sizes.length; i++) {
				sizeList.add(sizes[i]);
			}
		}
		
		private void populateTextColors() {
			for (int i = 0; i < COLORS_NAME.length; i++) {
				textColorList.add(COLORS_NAME[i].toString());
			}
		}
		
		private void populateBackColors() {
			for (int i = 0; i < COLORS_NAME.length; i++) {
				backColorList.add(COLORS_NAME[i].toString());
			}			
		}
		
		public List getFamilyList() {
			return familyList;
		}
		
		public List getSizeList() {
			return sizeList;
		}
		
		public List getTextColorList() {
			return textColorList;
		}
		
		public List getBackColorList() {
			return backColorList;
		}
		
		private void backupIndexes() {
			currentFamily = familyList.getSelectedIndex();
			currentSize = sizeList.getSelectedIndex();
			currentTextColor = textColorList.getSelectedIndex();
			currentBackColor = backColorList.getSelectedIndex();
		}
		
		private void rollbackIndexes() {
			familyList.select(currentFamily);
			sizeList.select(currentSize);
			textColorList.select(currentTextColor);
			backColorList.select(currentBackColor);
		}
	}
}
