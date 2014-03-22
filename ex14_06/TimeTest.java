import static org.junit.Assert.*;

import org.junit.Test;


public class TimeTest {

	@Test
	public void test() {
		Object lock = new Object();
		new Time(lock);
		new MessageThread(lock, 15);
		new MessageThread(lock, 7);
		
		try {
			Thread.sleep(31 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
