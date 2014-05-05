import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;

import javax.swing.ListSelectionModel;


public class ConstructorPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public DefaultListModel listModel = new DefaultListModel(); 
	private JList list = new JList(listModel);
	private final Interpret interpret;
	
	/**
	 * Create the panel.
	 */
	public ConstructorPanel(final Interpret interpret) {
		setLayout(null);
		this.interpret = interpret;
		
		JLabel label = new JLabel("\u5F15\u6570");
		label.setBounds(12, 239, 50, 13);
		add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callConstructor();
			}
		});
		textField.setBounds(55, 236, 220, 19);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u751F\u6210");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callConstructor();
			}
		});
		button.setBounds(286, 233, 93, 23);
		add(button);
		
		JLabel label_1 = new JLabel("\u500B\u6570");
		label_1.setBounds(12, 272, 50, 13);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callArrayConstructor();
			}
		});
		textField_1.setBounds(55, 269, 220, 19);
		add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u914D\u5217\u751F\u6210");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				callArrayConstructor();
			}
		});
		button_1.setBounds(286, 266, 93, 23);
		add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 21, 367, 203);
		add(scrollPane);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		scrollPane.setViewportView(list);

	}
	
	private void callConstructor() {
		if (list.isSelectionEmpty()) {
			interpret.putLog("コンストラクタが選択されていません。");
			return;
		}
		Constructor constructor = (Constructor) list.getSelectedValue();
		interpret.putLog(constructor.toString());
		try {
			String arg = textField.getText();
			Object[] params = interpret.parser.parse(arg, constructor);
			Object object = constructor.newInstance(params);
			interpret.objectListModel.addElement(new ListedObject(object));
		} catch (InvocationTargetException e) {
			interpret.putLog(e.getCause().toString());
		} catch (Exception e) {
			interpret.putLog(e.toString());			
			e.printStackTrace();
		}		
	}
	
	private void callArrayConstructor() {
		try {
			int number = Integer.valueOf(textField_1.getText());
			Class<?> type = interpret.getType();
			Object object = Array.newInstance(type, number);
			interpret.objectListModel.addElement(new ListedObject(object));
		} catch (NumberFormatException | NegativeArraySizeException e) {
			interpret.putLog("１以上の整数を入力してください。");
		}
	}
}
