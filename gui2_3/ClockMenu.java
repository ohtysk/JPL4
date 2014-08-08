import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

final class ClockMenu {
	private final Clock clock;
	private final String fontNames[];
	private static final String sizes[] = {"12", "14", "16", "18", "24", "30", "36", "48", "60"};
	private static final Color[] COLORS = {
			Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, 
			Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
			Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
	};
	private static final String[] COLORS_NAME = {
			"black", "blue", "cyan", "dark_gray",
			"gray", "green", "light_gray", "magenta",
			"orange", "pink", "red", "white", "yellow"
	};
	private static final Map COLOR_MAP = new TreeMap();
	static {
		for (int i = 0; i < COLORS.length; i++) {
			COLOR_MAP.put(COLORS_NAME[i], COLORS[i]);
		}
	}
	private final JMenu fontMenu;
	private final JMenu sizeMenu;
	private final JMenu foregroundMenu;
	private final JMenu backgroundMenu;
	private static final int INIT_FONT_INDEX = 0;
	private static final int INIT_SIZE_INDEX = 6;
	private static final int INIT_FOREGROUND_INDEX = 0;
	private static final int INIT_BACKGROUND_INDEX = 11;
	private final ButtonGroup fontGroup = new ButtonGroup();
	private final ButtonGroup sizeGroup = new ButtonGroup();
	private final ButtonGroup foregroundGroup = new ButtonGroup();
	private final ButtonGroup backgroundGroup = new ButtonGroup();

	ClockMenu(Clock clock) {
		this.clock = clock;
		fontNames = clock.getToolkit().getFontList();
		fontMenu = createFontMenu();
		sizeMenu = createSizeMenu();
		foregroundMenu = createForegroundMenu();
		backgroundMenu = createBackgroundMenu();
		changeMenu();
	}

	JMenu getFontMenu() { return fontMenu; }
	JMenu getSizeMenu() { return sizeMenu; }
	JMenu getForegroundMenu() { return foregroundMenu; }
	JMenu getBackgroundMenu() { return backgroundMenu; }
	
	private void changeMenu() {
		String fontName = getSelectedName(fontMenu);
		String fontSize = getSelectedName(sizeMenu);
		Font font = new Font(fontName, Font.PLAIN, Integer.parseInt(fontSize));
		clock.setClockFont(font);		
		clock.setClockForegroundColor(getSelectedColor(foregroundMenu));
		clock.setClockBackgroundColor(getSelectedColor(backgroundMenu));
		clock.repaint();
	}
	private String getSelectedName(JMenu menu) {
		for (int i = 0; i < menu.getItemCount(); i++) {
			JMenuItem item = menu.getItem(i);
			if (item.isSelected()) {
				return item.getText();
			}
		}
		return null;
	}
	private Color getSelectedColor(JMenu menu) {
		String name = getSelectedName(menu);
		return (Color)COLOR_MAP.get(name);
	}
	private JMenu createMenu(String title, String[] values, int index, ButtonGroup group) {
		JMenu menu = new JMenu(title);
		for(String name : values) {
			JRadioButtonMenuItem item = new JRadioButtonMenuItem(name);
			group.add(item);
			menu.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					changeMenu();
				}
			});
		}
		((JRadioButtonMenuItem)menu.getMenuComponent(index)).setSelected(true);		
		return menu;		
	}
	private JMenu createFontMenu() {
		return createMenu("Font Family", fontNames, INIT_FONT_INDEX, fontGroup);
	}

	private JMenu createSizeMenu() {
		return createMenu("Font Size", sizes, INIT_SIZE_INDEX, sizeGroup);
	}

	private JMenu createMenuWithIcon(String title, int index, ButtonGroup group) {
		JMenu menu = new JMenu(title);
		for (int i = 0; i < COLORS.length; i++) {
			final int ci = i;
			JRadioButtonMenuItem item = new JRadioButtonMenuItem(COLORS_NAME[i]);
			group.add(item);
			menu.add(item);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					changeMenu();
				}
			});
			Icon icon = new Icon() {
				@Override
				public int getIconHeight() { return 16; }
				@Override
				public int getIconWidth() { return 16; }
				@Override
				public void paintIcon(Component c, Graphics g, int x, int y) {
					g.setColor(COLORS[ci]);
					g.fillRect(x, y, getIconWidth(), getIconHeight());
				}
			};
			item.setIcon(icon);
		}
		((JRadioButtonMenuItem)menu.getMenuComponent(index)).setSelected(true);		
		return menu;
		
	}
	private JMenu createForegroundMenu() {
		return createMenuWithIcon("Foreground Color", INIT_FOREGROUND_INDEX, foregroundGroup);
	}

	private JMenu createBackgroundMenu() {
		return createMenuWithIcon("Background Color", INIT_BACKGROUND_INDEX, backgroundGroup);
	}
}
