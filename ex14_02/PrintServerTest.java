import static org.junit.Assert.*;

import org.junit.Test;


public class PrintServerTest {

	@Test
	public void test() {
		PrintServer printServer = new PrintServer();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {}
		printServer.run();
	}

}
