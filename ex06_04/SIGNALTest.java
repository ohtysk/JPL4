import static org.junit.Assert.*;

import org.junit.Test;


public class SIGNALTest {

	@Test
	public void testRed() {
		Color red = new Color("RED");
		assertEquals(red.toString(), SIGNAL.RED.getColor().toString());
	}

	@Test
	public void testBLUE() {
		Color blue = new Color("BLUE");
		assertEquals(blue.toString(), SIGNAL.BLUE.getColor().toString());
	}

	@Test
	public void testYELLOW() {
		Color yellow = new Color("YELLOW");
		assertEquals(yellow.toString(), SIGNAL.YELLOW.getColor().toString());
	}

}
