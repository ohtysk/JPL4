import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class Clock extends JFrame {
	final private JFrame frame;
	final private JPanel contentPane;
	final private ClockOption option;
	private Font font;
	private Color foregroundColor;
	private Color backbroundColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock frame = new Clock();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void setClockFont(Font font) {
		this.font = font;
	}
	public void setClockForegroundColor(Color color) {
		this.foregroundColor = color;
	}
	public void setClockBackgroundColor(Color color) {
		this.backbroundColor = color;
	}
	/**
	 * Create the frame.
	 */
	public Clock() {
		frame = this;
		option = new ClockOption(this);
		setTitle("Clock");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JMenuBar menubar = new JMenuBar();
		JMenuItem optionMenuItem = new JMenuItem("option");
		optionMenuItem.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				option.setVisible(true);
			}});
		menubar.add(optionMenuItem);
		this.setJMenuBar(menubar);
		JPanel panel = new ClockPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

	@Override
	public void paintComponents(Graphics g) {
		super.paintComponents(g);
		this.setForeground(foregroundColor);
		this.setBackground(backbroundColor);
		contentPane.repaint();
	}

	class ClockPanel extends JPanel implements ActionListener {
		private String text = (new Date()).toLocaleString().substring(11);
		private Timer timer;
		
		ClockPanel() {
			timer = new Timer(1000, this);
			timer.start();
		}
		
		@Override
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			g.setFont(font);
			this.setForeground(foregroundColor);
			this.setBackground(backbroundColor);
			FontMetrics fm = g.getFontMetrics();
			int sw = fm.stringWidth(text);
			int ascent = fm.getAscent();
			frame.setSize(sw * 3 / 2, ascent * 2 + 50);
			
			int w = this.getWidth();
			int h = this.getHeight();
			
			int x = (w - sw) / 2;
			int y = (h + ascent / 2) / 2;
			g.drawString(text, x, y);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			text = (new Date()).toLocaleString().substring(11);
			this.repaint();
		}
	}
}
