import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;


public class FieldPanel extends JPanel {
	private JTextField textField = new JTextField();
	public DefaultListModel listModel = new DefaultListModel();
	private JList list = new JList(listModel);
	private final Interpret interpret;
	private Field lastField = null;
	/**
	 * Create the panel.
	 */
	public FieldPanel(final Interpret interpret) {
		setLayout(null);
		this.interpret = interpret;
		
		JLabel label = new JLabel("\u5024");
		label.setBounds(12, 272, 50, 13);
		add(label);
		
		textField.setColumns(10);
		textField.setBounds(55, 269, 220, 19);
		add(textField);
		
		JButton button = new JButton("\u8A2D\u5B9A");
		button.setBounds(286, 266, 93, 23);
		add(button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 21, 367, 236);
		add(scrollPane);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (list.isSelectionEmpty()) {
					return;
				}
				Field field = (Field)list.getSelectedValue();
				if (lastField == field) {
					return;
				}
				field.setAccessible(true);
				try {
					if (Modifier.isStatic(field.getModifiers())) {
						textField.setText(field.get(null).toString());
					} else {
						Object object = interpret.getObject();
						if (object == null) {
							interpret.putLog(field.getName() + "はオブジェクトが選択されていないためアクセスできません。");
						} else {
							textField.setText(field.get(interpret.getObject()).toString());
						}
					}
				} catch (IllegalArgumentException | IllegalAccessException e1) {
					interpret.putLog(e1.toString());;
				}
				lastField = field;
			}
		});
		scrollPane.setViewportView(list);

	}

}
