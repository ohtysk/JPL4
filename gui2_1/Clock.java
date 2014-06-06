import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;


public class Clock extends JFrame {

	private JPanel contentPane;
	
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

	/**
	 * Create the frame.
	 */
	public Clock() {
		setTitle("Clock");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new ClockPanel();
		contentPane.add(panel, BorderLayout.CENTER);
	}

	class ClockPanel extends JPanel implements ActionListener {
		private String text = (new Date()).toLocaleString().substring(11);
		private Font font = new Font("Serif", Font.BOLD, 36);
		private Timer timer;
		
		ClockPanel() {
			timer = new Timer(1000, this);
			timer.start();
		}
		
		public void setFont(Font font) {
			this.font = font;
		}

		@Override
		public void paintComponent (Graphics g) {
			super.paintComponent(g);
			g.setFont(font);
			FontMetrics fm = g.getFontMetrics();
			int sw = fm.stringWidth(text);
			int ascent = fm.getAscent();				
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
