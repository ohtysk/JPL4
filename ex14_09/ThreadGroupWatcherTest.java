import static org.junit.Assert.*;

import org.junit.Test;


public class ThreadGroupWatcherTest {
	class ShortTimeThread implements Runnable {
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
	}
	
	@Test
	public void test() {
		ThreadGroup hoge = new ThreadGroup("hoge");
		ThreadGroup huga = new ThreadGroup("huga");

		new ThreadGroupWatcher(hoge, 1000, "");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {}		
		new ThreadGroupWatcher(huga, 1000, "        ");

		for (int i = 0; i < 100; i++) {
			new Thread(hoge, new ShortTimeThread()).start();
			new Thread(huga, new ShortTimeThread()).start();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}			
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
	}

}
