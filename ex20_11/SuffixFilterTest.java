import static org.junit.Assert.*;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import org.junit.Test;


public class SuffixFilterTest {

	@Test
	public void test() throws IOException {
		String suffix = "exe";
		String directory = "C:\\Windows";
		FileFilter filter = new SuffixFilter(suffix);
		File dir = new File(directory);
		File[] files = dir.listFiles(filter);
		for (File file : files) {
			System.out.println(file.getName());
		}
		System.out.printf("%n");
	}

}
