import static org.junit.Assert.*;

import org.junit.Test;


public class PassengerVehicleTest {

	@Test
	public void testClone() {
		double delta = 0.0001;
		PassengerVehicle p1 = new PassengerVehicle("first", 10);
		p1.setDirection(2.1);
		p1.setSpeed(50);
		p1.setCurrentNumberPassenger(15);
		PassengerVehicle p2 = p1.clone();
		assertEquals(null, p2.getFirstOwner());
		assertEquals(0, p2.getCurrentNumberPassenger());
		assertEquals(0, p2.getDirection(), delta);
		assertEquals(0, p2.getSpeed(), delta);
		assertNotEquals(p1.getId(), p2.getId());
		assertEquals(p1.getSeatNumber(), p2.getSeatNumber());
	}
}
