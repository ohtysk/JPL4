

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class DigitalClock extends Frame {

	private static final long serialVersionUID = 1L;

	private static final int windowWidth  = 500;
	private static final int windowHeight = 350;

	private final int timerDelay    = 100;
	private final int timerInterval = 100;

	Timer timer;
	TimerTask task;
	DigitalClockTime time;
	ImageManager imageManager;
	Graphics buffer;
	
	public static void main(String args[]) {
		DigitalClock app = new DigitalClock("DigitalClock application");
		
		app.setSize(windowWidth, windowHeight);
		app.setResizable(false);
		app.show();
		
		System.out.println("DigitalClock::main()");
	}
	
	public DigitalClock (String frameTitle) {
		super(frameTitle);
		time = new DigitalClockTime();
		imageManager = new ImageManager();
		timer = new Timer();
		task = new DigitalClockTask();
		timer.schedule(task, timerDelay, timerInterval);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent event) {
				close();
			}
		});
		
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println(arg0);
				switch(arg0.getKeyCode()) {
				case 0x1b:
					close();
					break;
				default:
					break;
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	private void close() {
		dispose();
		System.out.println("exit");
		timer.cancel();
		System.exit(0);
	}
	
	public void paint(Graphics g) {
		Dimension d = getSize();
		Image bufferImage = createImage(d.width, d.height);
		buffer = bufferImage.getGraphics();
		drawImages();
		g.drawImage(bufferImage,  0,  0,  this);
	}
	
	private void drawImages() {
		buffer.drawImage(imageManager.getNumber(time.getYear()[0]),   0, 20, this);
		buffer.drawImage(imageManager.getNumber(time.getYear()[1]), 100, 20, this);
		buffer.drawImage(imageManager.getNumber(time.getYear()[2]), 200, 20, this);
		buffer.drawImage(imageManager.getNumber(time.getYear()[3]), 300, 20, this);

		buffer.drawImage(imageManager.getNumber(time.getMonth()[0]),  50, 120, this);
		buffer.drawImage(imageManager.getNumber(time.getMonth()[1]), 150, 120, this);

		buffer.drawImage(imageManager.getSlash(), 250, 120, this);

		buffer.drawImage(imageManager.getNumber(time.getDay()[0]), 300, 120, this);
		buffer.drawImage(imageManager.getNumber(time.getDay()[1]), 400, 120, this);

		buffer.drawImage(imageManager.getNumber(time.getHour()[0]),  50, 220, this);
		buffer.drawImage(imageManager.getNumber(time.getHour()[1]), 150, 220, this);

		if (time.second[1] % 2 == 0) {
			buffer.drawImage(imageManager.getColon(), 250, 220, this);
		}

		buffer.drawImage(imageManager.getNumber(time.getMinute()[0]), 300, 220, this);
		buffer.drawImage(imageManager.getNumber(time.getMinute()[1]), 400, 220, this);
	}
	
	class DigitalClockTask extends TimerTask {
		@Override
		public void run() {
			time.update();
			repaint();
		}		
	}

	private class DigitalClockTime {
	    private int[] year;
	    private int[] month; 
	    private int[] day;
	    private int[] hour;
	    private int[] minute;
	    private int[] second;

	    DigitalClockTime() {
	    	update();
	    }
	    
	    public void update() {
	        Calendar calender = Calendar.getInstance(TimeZone.getDefault());
	        calender.setTime(new Date());
	        int y   = calender.get(Calendar.YEAR);          // —á: 1997
	        int m   = calender.get(Calendar.MONTH) + 1;     // (0..11) + 1
	        int d   = calender.get(Calendar.DATE);          // 1..31
	        int h   = calender.get(Calendar.HOUR_OF_DAY);   // 0..23
	        int min = calender.get(Calendar.MINUTE);      // 0..59
	        int sec = calender.get(Calendar.SECOND);      // 0..59
	        
	        year   = int2array(y, 4);
	        month  = int2array(m, 2);
	        day    = int2array(d, 2);
	        hour   = int2array(h, 2);
	        minute = int2array(min, 2);
	        second = int2array(sec, 2);
	    }
	
	    private int[] int2array(int data, int width) {
	    	int[] array = new int[width];
	    	for (int i = 0; i < width; i++) {
	    		array[width - i - 1] = data % 10;
	    		data /= 10;
	    	}
	    	return array;
	    }
	    
	    public int[] getYear() {
	    	return year;
	    }

	    public int[] getMonth() {
	    	return month;
	    }
	    
	    public int[] getDay() {
	    	return day;
	    }
	    
	    public int[] getHour() {
	    	return hour;
	    }
	    
	    public int[] getMinute() {
	    	return minute;
	    }
	    
	    public int[] getSecond() {
	    	return second;
	    }
	}

	private class ImageManager {
		private final int NUMBER_OF_NUMBERS = 10;
		private final Image[] numberImages = new Image[NUMBER_OF_NUMBERS];
		private final Image slashImage = readImage("slash.jpg");
		private final Image colonImage = readImage("colon.jpg");

		{
			for (int i = 0; i < NUMBER_OF_NUMBERS; i++) {
				numberImages[i] = readNumberImage(i);
			}
		}

		private Image readNumberImage(int number) {
			String file = String.format("%d.jpg", number);
			return readImage(file);
		}

		private Image readImage(String file) {
			return getToolkit().getImage(getClass().getResource(file));
		}
		
		public Image getNumber(int i) {
			return numberImages[i % NUMBER_OF_NUMBERS];
		}
		
		public Image getSlash() {
			return slashImage;
		}
		
		public Image getColon() {
			return colonImage;
		}
	}	
}
