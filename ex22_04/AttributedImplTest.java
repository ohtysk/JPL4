import static org.junit.Assert.*;

import java.util.Observable;
import java.util.Observer;

import org.junit.Test;


public class AttributedImplTest {

	@Test
	public void test() throws InterruptedException {
		int times = 50;
		int spanms = 50;
		AttributedImpl ai = new AttributedImpl();
		AttributedObserver ao = new AttributedObserver(ai);
		ai.addObserver(ao);
		for (int i = 0; i < times; i++) {
			Attr newAttr = new Attr(i + "", i);
			ai.add(newAttr);
			Thread.sleep(spanms);
		}
		for (int i = 0; i < times; i++) {
			ai.remove(i + "");
			Thread.sleep(spanms);
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
