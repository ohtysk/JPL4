import static org.junit.Assert.*;

import org.junit.Test;


public class LinkedListTest {

	@Test
	public void test1() {
		LinkedList<String> list = new LinkedList<String>("aaaa");
		assertEquals("aaaa", list.toString());
	}
	
	@Test
	public void test2() {
		LinkedList<String> list = new LinkedList<String>("hoge", "huga", "test");
		String expected = "hoge : huga : test";
		assertEquals(expected, list.toString());		
	}
	@Test
	public void test3() {
		int max = 500;
		Integer[] numbers = new Integer[max];
		for (int i = 0; i < max; i++) {
			numbers[i] = new Integer(i);
		}
		LinkedList<Integer> list = new LinkedList<Integer>((Integer [])numbers);
		
		String expected = "";
		for (int i = 0; i < max; i++) {
			expected += Integer.toString(i);
			if (i < max - 1) {
				expected += " : ";
			}
		}
		assertEquals(expected, list.toString());
	}
}
