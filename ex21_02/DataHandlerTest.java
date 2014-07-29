import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import org.junit.Test;


public class DataHandlerTest {
	@Test
	public void test0() throws IOException {
		DataHandler dh = new DataHandler();
		File file = new File("test.txt");
		byte[] a = dh.readFile(file);
		byte[] b = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
		assertEquals(b.length, a.length);
		for (int i = 0; i < a.length; i++)
			assertEquals(b[i], a[i]);
	}

	@Test
	public void test1() throws IOException {
		DataHandler dh = new DataHandler();
		File file = new File("test.txt");
		long before = System.nanoTime();
		byte[] a = dh.readFile(file);
		long running = System.nanoTime();
		byte[] b = dh.readFile(file);
		long after = System.nanoTime();
		
		for (int i = 0; i < a.length; i++) {
			assertEquals(a[i], b[i]);
		}
		System.out.println((running - before)+ "ns " + (after - before) + "ns");
	}

	@Test
	public void test2() throws IOException {
		DataHandler dh = new DataHandler();
		File file = new File("test.txt");
		File file2 = new File("test2.txt");
		long before = System.nanoTime();
		byte[] a = dh.readFile(file);
		long running = System.nanoTime();
		byte[] b = dh.readFile(file2);
		long after = System.nanoTime();

		for (int i = 0; i < a.length; i++) {
			assertEquals(a[i], b[i]);
		}
		System.out.println((running - before)+ "ns " + (after - before) + "ns");
	}

}