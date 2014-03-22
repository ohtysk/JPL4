
public class MessageThread implements Runnable {
	private long time = 0;
	private final int span;
	private final Object lock;
	private long initTime = System.currentTimeMillis(); 

	MessageThread(Object lock, int span) {
		this.lock = lock;
		this.span = span;
		
		new Thread(this).start();
	}
	
	public void run() {
		for (;;) {
			time++;
			synchronized (lock) {
				while(System.currentTimeMillis() - initTime < time * 1000) {
					try {
						lock.wait();
					} catch (Exception e) {
						System.out.println(e);
					}
				}
			}
			if (time % span == 0) {
				System.out.println("Message span " + span + "sec");
			}
		}
	}
}
