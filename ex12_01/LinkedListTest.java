import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void testFound() throws ObjectNotFoundException {
		LinkedList<String> list = new LinkedList<String>("hoge", "huga", "test");
		String expected = "test";
		LinkedList<?> actual = list.find("test");
		assertEquals(expected, actual.getValue().toString());
	}
	
	@Test(expected = ObjectNotFoundException.class)
	public void testNotFound() throws ObjectNotFoundException {
		LinkedList<String> list = new LinkedList<String>("hoge", "huga", "test");
		list.find("nothing");
	}

}
