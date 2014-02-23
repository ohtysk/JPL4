import java.awt.*;
import java.awt.event.*;

public class ClockWithMenu extends Frame {
	private MenuItem propertiesItem;
	private MenuItem quitItem;
	private MenuItemListener menuItemListener = new MenuItemListener();
	
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
			}
		}
		
	}
}
