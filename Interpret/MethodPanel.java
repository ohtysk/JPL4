import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;


public class MethodPanel extends JPanel {
	private JTextField textField;
	public DefaultListModel listModel = new DefaultListModel(); 
	/**
	 * Create the panel.
	 */
	public MethodPanel() {
		setLayout(null);
		
		JLabel label = new JLabel("\u5F15\u6570");
		label.setBounds(12, 272, 50, 13);
		add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(55, 269, 220, 19);
		add(textField);
		
		JButton button = new JButton("\u5B9F\u884C");
		button.setBounds(286, 266, 93, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 21, 367, 236);
		add(scrollPane);
		
		JList list = new JList(listModel);
		scrollPane.setViewportView(list);

	}
}
