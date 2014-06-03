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
			System.out.print(c + " ");
			for (int i = 0; i < c; i++)
				System.out.print(cbuf[i]);
		}
	}

}
