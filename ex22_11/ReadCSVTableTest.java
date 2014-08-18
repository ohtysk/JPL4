import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;


public class ReadCSVTableTest {

	@Test
	public void test() throws IOException {
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		List<String[]> res = ReadCSVTable.readCSVTable(in, cells);
		for (String[] strs : res) {
			for (String str : strs) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}

}
