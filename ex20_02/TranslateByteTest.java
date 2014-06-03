import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;


public class TranslateByteTest {

	@Test
	public void test() throws IOException {
		TranslateByte tb = new TranslateByte(
				new FileInputStream(new File("TranslateByte.java")),
				(byte)'t',
				(byte)'T');
		int b;
		while ((b = tb.read()) != -1) {
			System.out.print((char)b);
		}
	}

}
