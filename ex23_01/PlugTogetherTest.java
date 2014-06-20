import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class PlugTogetherTest {

	@Test
	public void test() throws IOException, InterruptedException {
		Process proc = Runtime.getRuntime().exec("cmd /c dir");
		PlugTogether.plugTogether(System.in, proc.getOutputStream());
		PlugTogether.plugTogether(System.out, proc.getInputStream());
		PlugTogether.plugTogether(System.err, proc.getErrorStream());
		proc.waitFor();
	}

}
