import static org.junit.Assert.*;

import org.junit.Test;


public class BitCountTest {

	@Test
	public void test() {
		for (int i = 0; i < 100; i++) {
			System.out.println(i + " " + BitCount.bitString(i) + " " + BitCount.bitCount(i));
		}
	}

}
