import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class TableTest {

	@Test
	public void testMake() throws IOException {
		File in = new File("input.txt");
		File out = new File("table.txt");
		Table.make(in, out);	
	}
	
	@Test
	public void testShow() throws IOException {
		File in = new File("input.txt");
		File table = new File("table.txt");
		Table.show(in, table);	
	}
	
}
