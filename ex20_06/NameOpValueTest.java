import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.junit.Test;


public class NameOpValueTest {

	@Test
	public void test() throws IOException {
		double e = 0.00000001;
		NameOpValue nov = new NameOpValue();
		Reader r = new FileReader(new File("input.txt"));
		nov.parseApply(r);
		assertEquals(5.0, nov.values[0], e);
		assertEquals(9.0, nov.values[1], e);
		assertEquals(-5.0, nov.values[2], e);
	}

}
