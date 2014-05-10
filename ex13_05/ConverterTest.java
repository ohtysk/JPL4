import static org.junit.Assert.*;

import org.junit.Test;


public class ConverterTest {

	@Test
	public void test1() {
		Converter c = new Converter();
		String before = "1234";
		String after = c.convert(before);
		assertEquals("1,234", after);
	}

	@Test
	public void test2() {
		Converter c = new Converter();
		String before = "123";
		String after = c.convert(before);
		assertEquals("123", after);
	}

	@Test
	public void test3() {
		Converter c = new Converter();
		String before = "12345678";
		String after = c.convert(before);
		assertEquals("12,345,678", after);
	}
}
