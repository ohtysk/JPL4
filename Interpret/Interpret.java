import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;


public class Interpret {

	private JFrame frmInterpret;
	private JTextField textField;
	private JTextField textField_1;

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
		initialize();
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
		
		textField = new JTextField();
		textField.setBounds(38, 17, 216, 19);
		frmInterpret.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("\u78BA\u8A8D");
		button.setBounds(266, 15, 75, 23);
		frmInterpret.getContentPane().add(button);
		
		JList list = new JList();
		list.setBounds(38, 81, 303, 193);
		frmInterpret.getContentPane().add(list);
		
		JLabel label = new JLabel("\u30AA\u30D6\u30B8\u30A7\u30AF\u30C8\u4E00\u89A7");
		label.setBounds(12, 60, 199, 13);
		frmInterpret.getContentPane().add(label);
		
		JLabel lblNewLabel = new JLabel("\u914D\u5217\u8981\u7D20\u4E00\u89A7");
		lblNewLabel.setBounds(12, 294, 199, 13);
		frmInterpret.getContentPane().add(lblNewLabel);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(365, 17, 404, 339);
		tabbedPane.add("コンストラクタ", new ConstructorPanel());
		tabbedPane.add("メソッド", new MethodPanel());
		tabbedPane.add("フィールド", new FieldPanel());
		frmInterpret.getContentPane().add(tabbedPane);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(365, 391, 404, 124);
		frmInterpret.getContentPane().add(textPane);
		
		JLabel label_1 = new JLabel("\u30ED\u30B0");
		label_1.setBounds(365, 368, 50, 13);
		frmInterpret.getContentPane().add(label_1);
		
		JList list_1 = new JList();
		list_1.setBounds(38, 317, 303, 165);
		frmInterpret.getContentPane().add(list_1);
		
		JLabel label_2 = new JLabel("\u8981\u7D20");
		label_2.setBounds(38, 497, 50, 13);
		frmInterpret.getContentPane().add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 494, 162, 19);
		frmInterpret.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton button_1 = new JButton("\u8A2D\u5B9A");
		button_1.setBounds(266, 492, 75, 23);
		frmInterpret.getContentPane().add(button_1);
	}
}
