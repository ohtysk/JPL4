import static org.junit.Assert.*;

import org.junit.Test;


public class CountStringTest {

	@Test
	public void testNormal() {
		int count = CountString.count("abababab", "ab");
		assertEquals(4, count);
	}
	
	@Test
	public void testNothing() {
		int count = CountString.count("abababab", "cc");
		assertEquals(0, count);
	}


}
