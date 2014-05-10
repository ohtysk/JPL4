import static org.junit.Assert.*;

import org.junit.Test;


public class ParserTest {

	@Test
	public void test() throws Exception {
		String input = "Boolean true\n"
				+ "Character c\n"
				+ "String string\n"
				+ "Byte 22\n"
				+ "Short -2\n"
				+ "Integer 2222\n"
				+ "Long 3\n"
				+ "Float 3.3f\n"
				+ "Double 4.2\n";
		Parser parser = new Parser();
		parser.parse(input);
		parser.showArray();
		
		assertEquals(true, parser.array.get(0));//Boolean
		assertEquals('c', parser.array.get(1));//Character
		assertEquals("string", parser.array.get(2));//String
		assertEquals((byte)22, parser.array.get(3));//Byte
		assertEquals((short)-2, parser.array.get(4));//Short
		assertEquals(2222, parser.array.get(5));//Integer
		assertEquals(3L, parser.array.get(6));//Long
		assertEquals(3.3F, parser.array.get(7));//Float
		assertEquals(4.2, parser.array.get(8));//Double
	}

}
