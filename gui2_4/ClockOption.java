import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

final class ClockOption extends JDialog {
	private final Clock clock;
	private final JDialog dialog;
	private final ClockPreference prefs;
	private GridBagLayout gbl = new GridBagLayout();
	private GridBagConstraints gbc = new GridBagConstraints();
	private final JPanel contentPanel = new JPanel();
	private final String fontNames[] = getToolkit().getFontList();
	private final String sizes[] = {"12", "14", "16", "18", "24", "30", "36", "48", "60"};
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
	private int lastFontIndex;
	private int lastSizeIndex;
	private int lastForegroundColorIndex;
	private int lastBackgroundColorIndex;
	JComboBox fontComboBox = new JComboBox(fontNames);
	JComboBox fontSizeComboBox = new JComboBox(sizes);
	JComboBox foregroundColorComboBox = new JComboBox(COLORS);
	JComboBox backgroundColorComboBox = new JComboBox(COLORS);
	{
		foregroundColorComboBox.setRenderer(new ColorRenderer());
		backgroundColorComboBox.setRenderer(new ColorRenderer());
	}
	
	private String colorName(Color color) {
		for (int i = 0; i < COLORS.length; i++) {
			if (COLORS[i] == color) return COLORS_NAME[i];
		}
		return "";
	}
	private void setClockOption() {
		clock.setClockFont(new Font((String)fontComboBox.getSelectedItem(), Font.PLAIN, Integer.parseInt((String)fontSizeComboBox.getSelectedItem())));
		clock.setClockForegroundColor((Color)foregroundColorComboBox.getSelectedItem());
		clock.setClockBackgroundColor((Color)backgroundColorComboBox.getSelectedItem());
	}
	private void updateIndexes() {
		lastFontIndex = fontComboBox.getSelectedIndex();
		lastSizeIndex = fontSizeComboBox.getSelectedIndex();
		lastForegroundColorIndex = foregroundColorComboBox.getSelectedIndex();
		lastBackgroundColorIndex = backgroundColorComboBox.getSelectedIndex();
	}
	
	private void rollbackIndexes() {
		fontComboBox.setSelectedIndex(lastFontIndex);
		fontSizeComboBox.setSelectedIndex(lastSizeIndex);
		foregroundColorComboBox.setSelectedIndex(lastForegroundColorIndex);
		backgroundColorComboBox.setSelectedIndex(lastBackgroundColorIndex);
	}
	
	int getFontIndex() {
		return fontComboBox.getSelectedIndex();
	}
	
	int getFontSizeIndex() {
		return fontSizeComboBox.getSelectedIndex();
	}
	
	int getForegroundColorIndex() {
		return foregroundColorComboBox.getSelectedIndex();
	}
	
	int getBackgroundColorIndex() {
		return backgroundColorComboBox.getSelectedIndex();
	}
	
	/**
	 * Create the dialog.
	 */
	public ClockOption(Clock clock, ClockPreference prefs) {
		this.clock = clock;
		this.prefs = prefs;
		dialog = this;
		setTitle("Options");
		setResizable(false);
		setBounds(prefs.getDialogX(), prefs.getDialogY(), 450, 300);
		setLayout(gbl);

		lastFontIndex = prefs.getFont();
		lastSizeIndex = prefs.getSize();
		lastForegroundColorIndex = prefs.getForegroundColor();
		lastBackgroundColorIndex = prefs.getBackgroundColor();
		rollbackIndexes();

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 200;
		gbc.gridheight = 50;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		add(new JLabel("Font: "), gbc);

		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx += gbc.gridwidth;
		add(fontComboBox, gbc);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy += gbc.gridheight;
		add(new JLabel("Size: "), gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx += gbc.gridwidth;
		add(fontSizeComboBox, gbc);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy += gbc.gridheight;
		add(new JLabel("Foreground Color: "), gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx += gbc.gridwidth;
		add(foregroundColorComboBox, gbc);			

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx = 0;
		gbc.gridy += gbc.gridheight;
		add(new JLabel("Background Color: "), gbc);
		
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridx += gbc.gridwidth;
		add(backgroundColorComboBox, gbc);

		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridx += 150;
		gbc.gridy += 50;
		gbc.weightx = 0.2;
		gbc.weighty = 0.2;
		JButton okButton = new JButton("OK");
		add(okButton, gbc);
		
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.gridx += 50;
		JButton cancellButton = new JButton("Cancel");
		add(cancellButton, gbc);
		
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateIndexes();
				setClockOption();
				setDialogPosition();
				dialog.setVisible(false);
			}
		});

		cancellButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rollbackIndexes();
				setDialogPosition();
				dialog.setVisible(false);
			}
		});

		setClockOption();
	}
	void setDialogPosition() {
		Point p = this.getLocationOnScreen();
		prefs.setDialogPosition(p.x, p.y);
	}
	class ColorRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList list, final Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            label.setText(colorName((Color)value));
            label.setIcon(new Icon() {
				@Override
				public int getIconHeight() { return 16; }
				@Override
				public int getIconWidth() { return 16; }
				@Override
				public void paintIcon(Component c, Graphics g, int x, int y) {
					g.setColor((Color)value);
					g.fillRect(x, y, getIconWidth(), getIconHeight());
				}});
			return label; 
		}		
	}
}
