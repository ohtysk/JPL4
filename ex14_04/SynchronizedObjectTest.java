import static org.junit.Assert.*;
import org.junit.Test;

import static java.lang.Math.pow;

public class SynchronizedObjectTest {

	@Test
	public void test() throws InterruptedException {
		for (int loop = 0; loop < 100; loop++) {
			SynchronizedObject.value = 0;
		
			for (int i = 0; i < 6; i++) {
				new Thread(new CallThread((int)pow(10, i), 10)).start();
			}
		
			Thread.sleep(80);
			assertEquals(999999, SynchronizedObject.value);
		}
	}

}
