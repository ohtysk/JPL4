import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void test() {
		LinkedListInterface list = new LinkedList();
		LinkedListInterface target = list; 
		target.setValue("first");
		for (int i = 0; i < 10; i++) {
			LinkedListInterface next = new LinkedList();
			next.setValue("No." + i);
			target.setNext(next);
			target = target.getNext();
		}
		assertEquals("first", list.getValue());
		target = list.getNext();
		int i = 0;
		while (target != null) {
			assertEquals("No." + i, target.getValue());
			target = target.getNext();
			i++;
		}
	}
}
