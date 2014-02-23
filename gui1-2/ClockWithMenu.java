import java.awt.*;
import java.awt.event.*;

public class ClockWithMenu extends Frame {
	private MenuItem propertiesItem;
	private MenuItem quitItem;
	private MenuItemListener menuItemListener = new MenuItemListener();
	private FontManager fontManager = new FontManager();
	
	public ClockWithMenu(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		
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
			add(fontManager.getStyleList());
			add(fontManager.getSizeList());			
		}
	}
	
	class FontManager {
		private List familyList = new List();
		private List styleList = new List();
		private List sizeList = new List();
		
		private int currentFamily = 0;
		private int currentStyle = 0;
		private int currentSize = 0;

		public FontManager() {
			populateFamilies();
			populateStyles();
			populateSizes();
			
			familyList.select(currentFamily);
			styleList.select(currentStyle);
			sizeList.select(currentSize);
		}
		
		public  Font getSelectedFont() {
			String family = familyList.getSelectedItem();
			int style = sizeList.getSelectedIndex();
			int size = Integer.parseInt(sizeList.getSelectedItem());
			return new Font(family, style, size);
		}
					
		private void populateFamilies() {
			String fontNames[] = getToolkit().getFontList();
			for (int i = 0; i < fontNames.length; i++) {
				familyList.add(fontNames[i]);
			}
		}
		
		private void populateStyles() {
			styleList.add("Plain");
			styleList.add("Bold");
			styleList.add("Italic");
			styleList.add("BoldItalic");
		}
		
		private void populateSizes() {
			String sizes[] = {"12", "14", "16", "18", "24", "36", "48"};
			
			for (int i = 0; i < sizes.length; i++) {
				sizeList.add(sizes[i]);
			}
		}
		
		public List getFamilyList() {
			return familyList;
		}
		
		public List getStyleList() {
			return styleList;
		}
		
		public List getSizeList() {
			return sizeList;
		}
		
		private void backupIndexes() {
			currentFamily = familyList.getSelectedIndex();
			currentStyle = styleList.getSelectedIndex();
			currentSize = sizeList.getSelectedIndex();
		}
		
		private void rollbackIndexes() {
			familyList.select(currentFamily);
			styleList.select(currentStyle);
			sizeList.select(currentSize);
		}
	}
}
