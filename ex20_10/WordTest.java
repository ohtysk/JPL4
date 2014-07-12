import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class WordTest {

	@Test
	public void test() throws IOException {
		Word word = new Word();
		File file = new File("Word.java");
		word.readFile(file);
		word.showMap();
	}

}
