import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class MethodPanel extends JPanel {
	private JTextField textField;
	public DefaultListModel listModel = new DefaultListModel();
	private JList list = new JList(listModel);
	private final Interpret interpret;
	/**
	 * Create the panel.
	 */
	public MethodPanel(final Interpret interpret) {
		setLayout(null);
		this.interpret = interpret;
		
		JLabel label = new JLabel("\u5F15\u6570");
		label.setBounds(12, 272, 50, 13);
		add(label);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callMethod();
			}
		});
		textField.setColumns(10);
		textField.setBounds(55, 269, 220, 19);
		add(textField);
		
		JButton button = new JButton("\u5B9F\u884C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				callMethod();
			}
		});
		button.setBounds(286, 266, 93, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 21, 367, 236);
		add(scrollPane);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(list);
	}
	
	private void callMethod() {
		if (list.isSelectionEmpty()) {
			interpret.putLog("メソッドが選択されていません。");
			return;
		}
		Method method = (Method) list.getSelectedValue();
		interpret.putLog(method + "をインボークします。");
		try {
			String arg = textField.getText();
			Object[] params = interpret.parser.parse(arg, method);
			Object object = interpret.getObject();
			if (object == null && !Modifier.isStatic(method.getModifiers())) {
				interpret.putLog("オブジェクトが選択されていません。");
				return;
			}
			Object ret = method.invoke(object, params);
			if (ret == null) {
				interpret.putLog("return null");
			} else {
				interpret.putLog("return-type=" + ret.getClass() + "\nreturn-value=" + ret);
			}
		} catch (InvocationTargetException e) {
			interpret.putLog(e.getCause().toString());
		} catch (Exception e) {
			interpret.putLog(e.toString());			
			//e.printStackTrace();
		}		

	}
}
