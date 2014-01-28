import static org.junit.Assert.*;

import org.junit.Test;


public class VehicleTest {

	@Test
	public void test() {
		double maxEnergy = 30;
		double currentEnergy = 30;
		Vehicle vehicle = new Vehicle();
		Battery battery = new Battery(maxEnergy, currentEnergy);
		vehicle.setEnergySource(battery);
		assertEquals(true, vehicle.start());
	}

	@Test
	public void test2() {
		double maxEnergy = 30;
		double currentEnergy = 0;
		Vehicle vehicle = new Vehicle();
		Battery battery = new Battery(maxEnergy, currentEnergy);
		vehicle.setEnergySource(battery);
		assertEquals(false, vehicle.start());
	}

}
