import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class AttrTest {

	@Test
	public void testString() throws IOException {
		Attr a = new Attr("1", "teststring");
		File file = new File("string.txt");
		a.writeValue(file);
		Attr b = new Attr("2", file);
		assertEquals(true, ((String)a.getValue()).equals((String)b.getValue()));
	}

	@Test
	public void testInt() throws IOException {
		Attr a = new Attr("1", 123);
		File file = new File("int.txt");
		a.writeValue(file);
		Attr b = new Attr("2", file);
		assertEquals(true, ((Integer)a.getValue()).equals((Integer)b.getValue()));
	}

	@Test
	public void testIntArray() throws IOException {
		int[] is = new int[100];
		for (int i = 0; i < is.length; i++) {
			is[i] = i;
		}
		Attr a = new Attr("1", is);
		File file = new File("int_array.txt");
		a.writeValue(file);
		Attr b = new Attr("2", file);
		int[] ais = (int[])a.getValue();
		Integer[] bis = (Integer[])b.getValue();
		for (int i = 0; i < is.length; i++)
			assertEquals(ais[i], (int)bis[i]);
	}

	@Test
	public void testDouble() throws IOException {
		Attr a = new Attr("1", 3.14);
		File file = new File("double.txt");
		a.writeValue(file);
		Attr b = new Attr("2", file);
		assertEquals(true, ((Double)a.getValue()).equals((Double)b.getValue()));
	}

	@Test
	public void testBoolean() throws IOException {
		Attr a = new Attr("1", false);
		File file = new File("boolean.txt");
		a.writeValue(file);
		Attr b = new Attr("2", file);
		assertEquals(true, ((Boolean)a.getValue()).equals((Boolean)b.getValue()));
	}

}
