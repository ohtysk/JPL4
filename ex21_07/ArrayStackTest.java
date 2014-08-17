import static org.junit.Assert.*;

import org.junit.Test;


public class ArrayStackTest {

	@Test
	public void testPushPop() {
		ArrayStack<String> stack = new ArrayStack<String>();
		int length = 100;
		for (int i = 0; i < length; i++) {
			stack.push(i + "");
		}
		for (int i = 0; i < length; i++) {
			int index = length - i - 1;
			assertEquals(index + "", stack.pop());
		}
	}

	@Test
	public void testPushPeek() {
		ArrayStack<String> stack = new ArrayStack<String>();
		int length = 100;
		for (int i = 0; i < length; i++) {
			stack.push(i + "");
			assertEquals(i + "", stack.peek());
			assertEquals(i + "", stack.peek());
		}
	}

	@Test
	public void testSearch() {
		ArrayStack<String> stack = new ArrayStack<String>();
		int length = 100;
		String zero = "0";
		for (int i = 0; i < length; i++) {
			stack.push(i + "");
			assertEquals(i + 1, stack.search(zero));
		}
	}
}
