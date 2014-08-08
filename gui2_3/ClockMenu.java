import javax.swing.JMenu;

class ClockMenu {
	private final Clock clock;
	ClockMenu(Clock clock) {
		this.clock = clock;
	}
	
	JMenu createFontMenu() {
		JMenu menu = new JMenu("Font Family");
		return menu;
	}

	JMenu createSizeMenu() {
		JMenu menu = new JMenu("Font Size");
		return menu;
	}

	JMenu createForegroundMenu() {
		JMenu menu = new JMenu("Foreground Color");
		return menu;
	}

	JMenu createBackgroundMenu() {
		JMenu menu = new JMenu("Background Color");
		return menu;
	}
}
