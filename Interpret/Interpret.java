import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;

import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;


public class Interpret {
	
	private Class<?> type = null;
	private Object object = null;
	JTextPane textPane = new JTextPane();
	Document log = textPane.getDocument();
	private final ConstructorPanel constructorPanel;
	private final MethodPanel methodPanel;
	private final FieldPanel fieldPanel;
	private JFrame frmInterpret;
	private JTextField txtJavaawtbutton;
	private JTextField textField_1;
	public final DefaultListModel objectListModel = new DefaultListModel(); 
	private final JList list = new JList(objectListModel);
	public final DefaultListModel arrayListModel = new DefaultListModel(); 
	private final JList list_1 = new JList(arrayListModel);
	public final Parser parser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Interpret window = new Interpret();
					window.frmInterpret.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Interpret() {
		constructorPanel =  new ConstructorPanel(this);
		methodPanel = new MethodPanel(this);
		fieldPanel = new FieldPanel(this);
		parser = new Parser(this);
		initialize();
	}
	
	public Object getObjectFromList(int index) throws Exception {
		return ((ListedObject)objectListModel.getElementAt(index)).getOject();
	}

	public Object getArrayElementFromList(int arrayIndex, int elementIndex) throws Exception {
		Object array = ((ListedObject)objectListModel.getElementAt(arrayIndex)).getOject();
		return Array.get(array, elementIndex);
	}
	
	public Object getObject() {
		return object;
	}
	
	public Class<?> getType() {
		return type;
	}
	
	public void putLog(String message) {
		try {
			log.insertString(log.getLength(), message + "\n", null);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
	}
	private void confirmType() {
		String text = txtJavaawtbutton.getText();
		try {
			type = Class.forName(text);
			putLog(text + "の確認が成功しました。");
			object = null;
		} catch (Exception e) {
			type = null;
			putLog(text + "の確認が失敗しました。");
			putLog(e.toString());
		}
		updateMembers();
		list.clearSelection();
		object = null;
	}
	
	private Constructor[] updateConstructors() {
		Object[] constructorObjects = uniqueMerge(type.getConstructors(), type.getDeclaredConstructors());
		Constructor[] constructors = new Constructor[constructorObjects.length];
		for (int i = 0; i < constructors.length; i++) {
			constructors[i] = (Constructor)constructorObjects[i];
		}
		return constructors;
	}

	private Method[] updateMethods() {
		Object[] methodObjects = uniqueMerge(type.getMethods(), type.getDeclaredMethods());
		Method[] methods = new Method[methodObjects.length];
		for (int i = 0; i < methods.length; i++) {
			methods[i] = (Method)methodObjects[i];
		}
		return methods;
	}

	private Field[] updateFields() {
		Object[] fieldObjects = uniqueMerge(type.getFields(), type.getDeclaredFields());
		Field[] fields = new Field[fieldObjects.length];
		for (int i = 0; i < fields.length; i++) {
			fields[i] = (Field)fieldObjects[i];
		}
		return fields;
	}
	
	private void updateMembers() {
		constructorPanel.listModel.clear();
		methodPanel.listModel.clear();
		fieldPanel.listModel.clear();
		if (type != null) {
			Constructor[] constructors = updateConstructors();
			for (Member member : constructors)
				constructorPanel.listModel.addElement(member);
			
			Method[] methods = updateMethods();
			for (Member member : methods)
				methodPanel.listModel.addElement(member);

			Field[] fields = updateFields();
			for (Member member : fields)
				fieldPanel.listModel.addElement(member);
		}
	}

	private void updateArrayCore() {
		int arrayIndex = ((ListedObject)list.getSelectedValue()).getIndex();
		int length = Array.getLength(object);
		for (int i = 0; i < length; i++) {
			Object element = Array.get(object, i);
			arrayListModel.addElement(new ListedArray(element, arrayIndex, i, object));
		}		
	}
	private void updateArray() {
		arrayListModel.clear();
		if (!object.getClass().isArray()) {
			return;
		}
		updateArrayCore();
	}

	private void setArray() {
		if (list_1.isSelectionEmpty()) {
			putLog("配列の要素が選択されていません。");
			return;
		}				
		String str = textField_1.getText();
		try {
			
			/*
			int index = Integer.valueOf(str).intValue();
			putLog(index + "");
			if (index < 0 || objectListModel.capacity() <= index) {
				putLog("指定されたオブジェクトがありません。");
				return;
			}
			ListedArray listedArray = (ListedArray)list_1.getSelectedValue();
			Object element = ((ListedObject)objectListModel.elementAt(index)).getOject();
			listedArray.setObject(element);
			*/
			Object element = parser.parse(str, void.class);
			ListedArray listedArray = (ListedArray)list_1.getSelectedValue();
			listedArray.setObject(element);
			list_1.updateUI();
			if (element != null) {
				type = element.getClass();
				txtJavaawtbutton.setText(type.getName());
			}
			updateMembers();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			putLog("#n または #n[m] という形式でオブジェクトを指定してください。例 #3");			
		} catch (Exception e) {
			e.printStackTrace();
			putLog(e.toString());						
		}
	}
	private static Object[] uniqueMerge(Object[] as, Object[] bs) {
		HashSet<Object> merged = new HashSet<Object>();
		for (Object a : as)
			merged.add(a);
		
		for (Object b : bs)
			merged.add(b);
		return merged.toArray();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frmInterpret = new JFrame();
		frmInterpret.setResizable(false);
		frmInterpret.setTitle("Interpret");
		frmInterpret.setBounds(100, 100, 789, 583);
		frmInterpret.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmInterpret.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("\u30D5\u30A1\u30A4\u30EB");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmQuit = new JMenuItem("\u7D42\u4E86");
		mntmQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmInterpret.dispose();
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmQuit);
		frmInterpret.getContentPane().setLayout(null);
		
		JLabel lblType = new JLabel("\u578B");
		lblType.setBounds(12, 20, 50, 13);
		frmInterpret.getContentPane().add(lblType);
		
		txtJavaawtbutton = new JTextField();
		txtJavaawtbutton.setText("java.awt.Button");
		txtJavaawtbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmType();
			}
		});
		txtJavaawtbutton.setBounds(38, 17, 216, 19);
		frmInterpret.getContentPane().add(txtJavaawtbutton);
		txtJavaawtbutton.setColumns(10);
		
		JButton button = new JButton("\u78BA\u8A8D");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				confirmType();
			}
		});
		button.setBounds(266, 15, 75, 23);
		frmInterpret.getContentPane().add(button);
		
		JLabel label = new JLabel("\u30AA\u30D6\u30B8\u30A7\u30AF\u30C8\u4E00\u89A7");
		label.setBounds(12, 60, 199, 13);
		frmInterpret.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u914D\u5217\u8981\u7D20\u4E00\u89A7");
		lblNewLabel.setBounds(12, 294, 199, 13);
		frmInterpret.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(365, 17, 404, 339);
		tabbedPane.add("コンストラクタ", constructorPanel);
		tabbedPane.add("メソッド", methodPanel);
		tabbedPane.add("フィールド", fieldPanel);
		frmInterpret.getContentPane().add(tabbedPane);
		
		JLabel label_1 = new JLabel("\u30ED\u30B0");
		label_1.setBounds(365, 368, 50, 13);
		frmInterpret.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("\u8981\u7D20");
		label_2.setBounds(38, 497, 50, 13);
		frmInterpret.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setArray();
			}
		});
		textField_1.setBounds(92, 494, 162, 19);
		frmInterpret.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u8A2D\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setArray();
			}
		});
		button_1.setBounds(266, 492, 75, 23);
		frmInterpret.getContentPane().add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(365, 391, 404, 119);
		frmInterpret.getContentPane().add(scrollPane);
		
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 81, 303, 193);
		frmInterpret.getContentPane().add(scrollPane_1);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list.isSelectionEmpty()) {
					return;
				}
				object = ((ListedObject)list.getSelectedValue()).getOject();
				type = object.getClass();
				txtJavaawtbutton.setText(type.getName());
				updateMembers();
				updateArray();
			}
		});
		scrollPane_1.setViewportView(list);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(38, 317, 303, 165);
		frmInterpret.getContentPane().add(scrollPane_2);
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list_1.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				if (list_1.isSelectionEmpty()) {
					return;
				}				
				object = ((ListedArray)list_1.getSelectedValue()).getObject();
				if (object == null) {
					type = null;
					txtJavaawtbutton.setText("");
				} else {
					type = object.getClass();
					txtJavaawtbutton.setText(type.getName());
				}
				updateMembers();
			}
		});
		scrollPane_2.setViewportView(list_1);
	}

}
