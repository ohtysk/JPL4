import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class DataHandlerTest {

	@Test
	public void test() throws IOException {
		DataHandler dh = new DataHandler();
		File file = new File("test.txt");
		long before = System.currentTimeMillis();
		byte[] a = dh.readFile(file);
		long running = System.currentTimeMillis();
		byte[] b = dh.readFile(file);
		long after = System.currentTimeMillis();
		
		for (int i = 0; i < a.length; i++) {
			assertEquals(a[i], b[i]);
		}
		System.out.println((running - before)+ "ms " + (after - before) + "ms");
	}

	@Test
	public void test2() throws IOException {
		DataHandler dh = new DataHandler();
		File file = new File("test.txt");
		File file2 = new File("test2.txt");
		long before = System.currentTimeMillis();
		byte[] a = dh.readFile(file);
		long running = System.currentTimeMillis();
		byte[] b = dh.readFile(file2);
		long after = System.currentTimeMillis();
		
		for (int i = 0; i < a.length; i++) {
			assertEquals(a[i], b[i]);
		}
		System.out.println((running - before)+ "ms " + (after - before) + "ms");
	}

}
