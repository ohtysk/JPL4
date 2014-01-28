import static org.junit.Assert.*;

import org.junit.Test;


public class ColorTest {

	@Test
	public void test() {
		String colorStr = "white";
		Color color = new Color(colorStr);
		assertEquals(colorStr, color.toString());
	}

}
