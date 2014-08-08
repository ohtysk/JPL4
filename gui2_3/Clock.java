import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class Clock extends JWindow {
	final private JWindow frame;
	final private JPanel contentPane;
	final private MouseAdapter mouseLisner;
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
		mouseLisner = new DragWindowListener(this);
		frame.addMouseListener(mouseLisner);
		frame.addMouseMotionListener(mouseLisner);
		
		setBounds(100, 100, 275, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
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

	class DragWindowListener extends MouseAdapter {
		private final Point startPt = new Point();
		private final JWindow window;
		
		DragWindowListener(JWindow window) {
			this.window = window;
		}

		@Override
		public void mousePressed(MouseEvent me) {
			startPt.setLocation(me.getPoint());
		}

		@Override
		public void mouseDragged(MouseEvent me) {		
			Point eventLocationOnScreen = me.getLocationOnScreen();
			window.setLocation(eventLocationOnScreen.x - startPt.x, eventLocationOnScreen.y - startPt.y);
		}
	}
}
