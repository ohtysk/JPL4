import static org.junit.Assert.*;
import org.junit.Test;

import static java.lang.Math.pow;

public class SyncronisedObjectTest {

	@Test
	public void test() throws InterruptedException {
		for (int loop = 0; loop < 100; loop++) {
			SyncronisedObject object = new SyncronisedObject();
		
			for (int i = 0; i < 6; i++) {
				new Thread(new CallThread(object, (int)pow(10, i), 10)).start();
			}
		
			Thread.sleep(80);
			assertEquals(999999, object.value);
		}
	}

}
