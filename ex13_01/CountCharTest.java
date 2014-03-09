import static org.junit.Assert.*;

import org.junit.Test;


public class CountCharTest {

	@Test
	public void testNormal() {
		int count = CountChar.count("abababab", 'a');
		assertEquals(4, count);
	}
	
	@Test
	public void testNothing() {
		int count = CountChar.count("abababab", 'c');
		assertEquals(0, count);
	}

}
