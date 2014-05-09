import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;


public class TranslateByteTest {

	@Test
	public void test() {
		TranslateByte tb = new TranslateByte();
		try {
			tb.setStream(new FileInputStream(new File("TranslateByte.java")), System.out, (byte)'t', (byte)'T');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
