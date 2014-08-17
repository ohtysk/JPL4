import static org.junit.Assert.*;

import org.junit.Test;


public class WhichCharsTest {

	@Test
	public void test() {
		String str = "Testing 1 2 3\uffff";
		WhichChars wc = new WhichChars(str);
		System.out.println(wc);
	}

}
