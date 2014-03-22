import static org.junit.Assert.*;
import org.junit.Test;

import static java.lang.Math.pow;

public class SynchronizedObjectTest {

	@Test
	public void test() throws InterruptedException {
		for (int loop = 0; loop < 100; loop++) {
			SynchronizedObject object = new SynchronizedObject();
		
			for (int i = 0; i < 6; i++) {
				new Thread(new CallThread(object, (int)pow(10, i), 10)).start();
			}
		
			Thread.sleep(100);
			assertEquals(0, object.value);
		}
	}

}
