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
		for (int i = 0; i < 15; i++) {
			String owner = "first owner " + i;
			Vehicle v = new Vehicle(owner);

			double speed = i * 0.5; 
			v.setSpeed(speed);

			double direction = i * 1.5;
			v.setDirection(direction);
			
			assertEquals(i + " (" + owner + ", " + speed + ", " + direction + ")", v.toString());

		}

	}

}
