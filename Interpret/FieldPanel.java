import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;


public class FieldPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public FieldPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("\u5024");
		label.setBounds(12, 272, 50, 13);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(55, 269, 220, 19);
		add(textField);
		
		JButton button = new JButton("\u8A2D\u5B9A");
		button.setBounds(286, 266, 93, 23);
		add(button);
		
		JList list = new JList();
		list.setBounds(12, 21, 367, 236);
		add(list);

	}

}
