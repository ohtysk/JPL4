import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;


public class ReadAttrsTest {

	@Test
	public void test() throws IOException {
		Map<String, Object> map = ReadAttrs.readAttrs(new FileReader(new File("data.attr")));
		for(Entry<String, Object> e : map.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}
	@Test(expected = IOException.class)
	public void testException() throws IOException {
		Map<String, Object> map = ReadAttrs.readAttrs(new FileReader(new File("miss.attr")));
	}

}
