import static org.junit.Assert.*;

import org.junit.Test;


public class GasTankTest {

	@Test
	public void test() {
		double maxGas = 10;
		double currentGas = 0;
		double delta = 0.00001;
		GasTank gasTank = new GasTank(maxGas, currentGas);
		assertEquals(true, gasTank.empty());
		assertEquals(maxGas, gasTank.getMaxGas(), delta);
	}

}
