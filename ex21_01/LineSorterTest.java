import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Test;


public class LineSorterTest {

	@Test
	public void test() throws IOException {
		LineSorter ls = new LineSorter("LineSorter.java");
		List<String> list = ls.getList();
		for (String line : list)
			System.out.println(line);
	}

}
