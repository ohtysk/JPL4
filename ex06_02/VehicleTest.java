import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class VehicleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		final double delta = 0.001;
		Vehicle v = new Vehicle("first owner");
		v.setDirection(1.5);
		assertEquals(1.5, v.getDirection(), delta);

		v.turn(- 2.5);
		assertEquals(1.5 - 2.5, v.getDirection(), delta);

		v.turn(Vehicle.Direction.TURN_RIGHT);
		assertEquals(1.5 - 2.5 + 90, v.getDirection(), delta);

		v.turn(Vehicle.Direction.TURN_LEFT);
		assertEquals(1.5 - 2.5, v.getDirection(), delta);
	}
}
