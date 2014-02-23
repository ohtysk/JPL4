import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void testClone() {
		String[] strings = {"1", "12", "123", "1234", "12345"};
		LinkedList list = new LinkedList(strings);
		LinkedList listClone = list.clone();
		
		LinkedList target = list;
		LinkedList targetClone = listClone;
		while(target != null) {
			assertEquals(target.getValue(), targetClone.getValue());
			assertNotEquals(target, targetClone);
			target = target.getNext();
			targetClone = targetClone.getNext();
		}
	}
}
