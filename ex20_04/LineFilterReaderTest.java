import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;


public class LineFilterReaderTest {

	@Test
	public void test() throws IOException {
		LineFilterReader lfr = new LineFilterReader(new FileReader(new File("LineFilterReader.java")));
		int c;
		int len = 256;
		char[] cbuf = new char[len];
		while ((c = lfr.read(cbuf, 0, len)) != -1) {
			String str = new String(cbuf).substring(0, c);
			System.out.print(c + " " + str);			
		}
	}

}
