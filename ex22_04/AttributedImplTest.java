import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;


public class AttributedImplTest {

	@Test
	public void test() throws InterruptedException {
		final AttributedImpl ai = new AttributedImpl();
		new Thread(new Runnable() {

			@Override
			public void run() {
				AttributedObserver ao = new AttributedObserver(ai);
				while (true) {
					
				}
			}
		}).run();
		for (int i = 0; i < 100; i++) {
			Attr newAttr = new Attr(i + "", i);
			ai.add(newAttr);
			Thread.sleep(100);
		}
	}

	class AttributedObserver implements Observer {
		private Attributed watching;
		AttributedObserver(Attributed watching) {
			this.watching = watching;
		}
		

		@Override
		public void update(Observable o, Object attr) {
			String attrName = ((Attr)attr).getName();
			if (watching.find(attrName) == null) {
				System.out.println("remove : " + attrName);
			} else {
				System.out.println("add : " + attrName);					
			}
		}
		
	}
}
