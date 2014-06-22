import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;


public class StreamTest {

	@Test
	public void testEncryptOutputStream() throws IOException {
		File f = new File("hoge");
		FileOutputStream os = new FileOutputStream(f);
		EncryptOutputStream eos = new EncryptOutputStream(os);
		byte[] write = { 1, 2, 3, 4};
		eos.write(write);
		eos.close();
		byte[] expected = { 2, 3, 4, 5};
		byte[] actual = new byte[256];
		FileInputStream is = new FileInputStream(f);
		int length = is.read(actual);
		assertEquals(4, length);
		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

	@Test
	public void testDecryptOutputStream() throws IOException {
		File f = new File("hoge2");
		FileOutputStream os = new FileOutputStream(f);
		byte[] write = { 1, 2, 3, 4};
		os.write(write);
		os.close();
		byte[] expected = { 0, 1, 2, 3};
		byte[] actual = new byte[256];
		FileInputStream is = new FileInputStream(f);
		DecriptInputStream dis = new DecriptInputStream(is);
		int length = dis.read(actual);
		assertEquals(4, length);
		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}
	@Test
	public void testEncriptDecryptOutputStream() throws IOException {
		File f = new File("hoge3");
		FileOutputStream os = new FileOutputStream(f);
		EncryptOutputStream eos = new EncryptOutputStream(os);
		byte[] write = { 1, 2, 3, 4};
		eos.write(write);
		eos.close();
		byte[] expected = { 1, 2, 3, 4};
		byte[] actual = new byte[256];
		FileInputStream is = new FileInputStream(f);
		DecriptInputStream dis = new DecriptInputStream(is);
		int length = dis.read(actual);
		assertEquals(4, length);
		for (int i = 0; i < 4; i++) {
			assertEquals(expected[i], actual[i]);
		}
	}

}
