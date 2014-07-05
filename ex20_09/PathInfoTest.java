import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;


public class PathInfoTest {

	@Test
	public void test() throws IOException {
		PathInfo.show(new File("PathInfo.java"));
	}

}
