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
		double delta = 0.01;
		for (int i = 0; i < 15; i++) {
			Vehicle v = new Vehicle();
			double speed = i * 0.5;
			v.setSpeed(speed);
			assertEquals(speed, v.getSpeed(), delta);

			double direction = i * 1.5;
			v.setDirection(direction);
			assertEquals(direction, v.getDirection(), delta);

			String owner = "owner" + i;
			v.setOwner(owner);
			assertEquals(owner, v.getOwner());
			
			assertEquals(i, v.getId());
		}
	}

}
