import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public final class Clock extends JFrame {
	private final JFrame frame;
	private final JPanel contentPane;
	private final ClockOption option;
	private final ClockPreference prefs = new ClockPreference();
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
		option = new ClockOption(this, prefs);
		setTitle("Clock");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				quit();
			}
		});
		setBounds(prefs.getClockX(), prefs.getClockY(), 200, 200);
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

	protected void quit() {
		if (option.isVisible()) {
			option.setDialogPosition();
		}
		Point p = this.getLocationOnScreen();
		prefs.setClockPosition(p.x, p.y);
		prefs.setFont(option.getFontIndex(),
				option.getFontSizeIndex(),
				option.getForegroundColorIndex(),
				option.getBackgroundColorIndex());
		prefs.save();
		dispose();
		System.exit(0);
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
