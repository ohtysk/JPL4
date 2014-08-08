import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public final class Clock extends JWindow {
	final private JWindow window;
	final private JPanel contentPane;
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
		window = this;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		JPanel panel = new ClockPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		JPopupMenu popup = new JPopupMenu();
		ClockMenu clockMenu = new ClockMenu(this);
		popup.add(clockMenu.getFontMenu());
		popup.add(clockMenu.getSizeMenu());
		popup.add(clockMenu.getForegroundMenu());
		popup.add(clockMenu.getBackgroundMenu());
		JMenuItem quitMenu = new JMenuItem("Quit");
		quitMenu.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.disable();
				System.exit(0);
			}
		});
		popup.add(quitMenu);
		MouseAdapter mouseLisner = new ClockWindowListener(this, popup);
		window.addMouseListener(mouseLisner);
		window.addMouseMotionListener(mouseLisner);
		
		setBounds(100, 100, 275, 150);
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
			int descent = fm.getDescent();
			window.setSize(sw * 3 / 2, fm.getHeight() * 3 / 2);
			
			int w = this.getWidth();
			int h = this.getHeight();
			
			int x = (w - sw) / 2;
			int y = (h + ascent - descent) / 2;//(h + ascent / 2) / 2;
			g.drawString(text, x, y);
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			text = (new Date()).toLocaleString().substring(11);
			this.repaint();
		}
	}

	class ClockWindowListener extends MouseAdapter {
		private final Point startPt = new Point();
		private final JWindow window;
		private final JPopupMenu popup;
		
		ClockWindowListener(JWindow window, JPopupMenu popup) {
			this.window = window;
			this.popup = popup;
		}

		@Override
		public void mouseReleased(MouseEvent me) {
			if (me.isPopupTrigger()) {
				popup.show(me.getComponent(), me.getX(), me.getY());
			} else {
				startPt.setLocation(me.getPoint());
			}
		}

		@Override
		public void mousePressed(MouseEvent me) {
			if (me.isPopupTrigger()) {
				popup.show(me.getComponent(), me.getX(), me.getY());
			} else {
				startPt.setLocation(me.getPoint());
			}
		}

		@Override
		public void mouseDragged(MouseEvent me) {		
			Point eventLocationOnScreen = me.getLocationOnScreen();
			window.setLocation(eventLocationOnScreen.x - startPt.x, eventLocationOnScreen.y - startPt.y);
		}
	}
	
}
