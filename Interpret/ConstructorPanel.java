import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ConstructorPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public ConstructorPanel() {
		setLayout(null);
		
		JList list = new JList();
		list.setBounds(12, 21, 367, 192);
		add(list);
		
		JLabel label = new JLabel("\u5F15\u6570");
		label.setBounds(12, 239, 50, 13);
		add(label);
		
		textField = new JTextField();
		textField.setBounds(55, 236, 220, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u751F\u6210");
		button.setBounds(286, 233, 93, 23);
		add(button);
		
		JLabel label_1 = new JLabel("\u500B\u6570");
		label_1.setBounds(12, 272, 50, 13);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(55, 269, 220, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u914D\u5217\u751F\u6210");
		button_1.setBounds(286, 266, 93, 23);
		add(button_1);

	}

}
