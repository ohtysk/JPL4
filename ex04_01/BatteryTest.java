import static org.junit.Assert.*;

import org.junit.Test;


public class BatteryTest {

	@Test
	public void test() {
		double maxEnergy = 10;
		double currentEnergy = 0;
		double delta = 0.00001;
		Battery battery = new Battery(maxEnergy, currentEnergy);
		assertEquals(true, battery.empty());
		assertEquals(maxEnergy, battery.getMaxEnergy(), delta);
	}

}
