
public class Time implements Runnable {
	long time = 0;
	long lastTime = 0;
	private long initTime = System.currentTimeMillis(); 
	private final Object lock;
	Time(Object lock) {
		this.lock = lock;
		new Thread(this).start();
	}
	
	public void run() {
		for (;;) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
			lastTime = time;
			time = (System.currentTimeMillis() - initTime) / 1000;
			if (lastTime != time) {
				System.out.println("time: " + time + " sec");
			}
			synchronized (lock) {
				try {
					lock.notifyAll();
				} catch (Exception e) {}
			}
		}
	}
}
