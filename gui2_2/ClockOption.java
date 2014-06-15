import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;

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


public class ClockOption extends JDialog {
	private final Clock clock;
	private final JDialog dialog;
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
	private int lastFontIndex = 0;
	private int lastSizeIndex = 6;
	private int lastForegroundColorIndex = 0;
	private int lastBackgroundColorIndex = 11;
	JComboBox comboBox = new JComboBox(fontNames);
	JComboBox comboBox_1 = new JComboBox(sizes);
	JComboBox comboBox_2 = new JComboBox(COLORS);
	JComboBox comboBox_3 = new JComboBox(COLORS);
	{
		comboBox_2.setRenderer(new ColorRenderer());
		comboBox_3.setRenderer(new ColorRenderer());
		rollbackIndexes();
	}
	
	private String colorName(Color color) {
		for (int i = 0; i < COLORS.length; i++) {
			if (COLORS[i] == color) return COLORS_NAME[i];
		}
		return "";
	}
	private void setClockOption() {
		clock.setClockFont(new Font((String)comboBox.getSelectedItem(), Font.PLAIN, Integer.parseInt((String)comboBox_1.getSelectedItem())));
		clock.setClockForegroundColor((Color)comboBox_2.getSelectedItem());
		clock.setClockBackgroundColor((Color)comboBox_3.getSelectedItem());
	}
	private void updateIndexes() {
		lastFontIndex = comboBox.getSelectedIndex();
		lastSizeIndex = comboBox_1.getSelectedIndex();
		lastForegroundColorIndex = comboBox_2.getSelectedIndex();
		lastBackgroundColorIndex = comboBox_3.getSelectedIndex();
	}
	
	private void rollbackIndexes() {
		comboBox.setSelectedIndex(lastFontIndex);
		comboBox_1.setSelectedIndex(lastSizeIndex);
		comboBox_2.setSelectedIndex(lastForegroundColorIndex);
		comboBox_3.setSelectedIndex(lastBackgroundColorIndex);
	}

	/**
	 * Create the dialog.
	 */
	public ClockOption(Clock clock) {
		this.clock = clock;
		dialog = this;
		setTitle("Options");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblFont = new JLabel("Font");
		lblFont.setBounds(86, 62, 50, 13);
		contentPanel.add(lblFont);
		
		JLabel lblFontSize = new JLabel("Font Size");
		lblFontSize.setBounds(86, 97, 50, 13);
		contentPanel.add(lblFontSize);
		
		JLabel lblForegroundColor = new JLabel("Foreground Color");
		lblForegroundColor.setBounds(86, 132, 103, 13);
		contentPanel.add(lblForegroundColor);
		
		JLabel lblBackgroundColor = new JLabel("Background Color");
		lblBackgroundColor.setBounds(86, 167, 103, 13);
		contentPanel.add(lblBackgroundColor);
		
		comboBox.setBounds(201, 62, 188, 21);
		contentPanel.add(comboBox);
		
		comboBox_1.setBounds(201, 97, 188, 21);
		contentPanel.add(comboBox_1);
		
		comboBox_2.setBounds(201, 132, 188, 21);
		contentPanel.add(comboBox_2);
		
		comboBox_3.setBounds(201, 167, 188, 21);
		contentPanel.add(comboBox_3);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("OK");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				updateIndexes();
				setClockOption();
				dialog.setVisible(false);
			}
		});
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rollbackIndexes();
				dialog.setVisible(false);
			}
		});
		buttonPane.add(cancelButton);
		setClockOption();
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
