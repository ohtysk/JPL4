import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;


public class IgnoreCommentTest {

	@Test
	public void test() throws IOException {
		List<String> list = IgnoreComment.getToken(new FileReader(new File("data.txt")));
		for (String token : list) {
			System.out.println(token);
		}
	}

}
