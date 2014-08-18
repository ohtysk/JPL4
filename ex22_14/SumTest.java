import static org.junit.Assert.*;

import org.junit.Test;


public class SumTest {

	@Test
	public void test() {
		String str = "pi is 3 or 3.1 or 3.14";
		double expected = 9.24;
		double e = 0.000001;
		double actual = Sum.fromString(str);
		assertEquals(expected, actual, e);
	}

}
