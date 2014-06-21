import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;


public class PlugTogetherTest {

	public static void main(String []args) throws IOException, InterruptedException {
		PlugTogetherTest p = new PlugTogetherTest();
		p.test();
	}
	@Test
	public void test() throws IOException, InterruptedException {
		Process proc = Runtime.getRuntime().exec("myecho");
		PlugTogether.plugTogether(System.in, proc.getOutputStream());
		PlugTogether.plugTogether(System.out, proc.getInputStream());
		PlugTogether.plugTogether(System.err, proc.getErrorStream());
		for (int i = 0; i < 10; i++)
			System.out.println("hoge\n");
		proc.waitFor();
	}

}
