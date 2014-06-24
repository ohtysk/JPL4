import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class GrepTest {

	@Test
	public void test() throws IOException {
		String [] args = new String[2];
		args[0] = "GrepTest.java";
		args[1] = "Grep";
		Grep.main(args);
	}

}
