import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class VehicleTest {
	private static final double delta = 0.1;

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

	@SuppressWarnings("deprecation")
	@Test
	public void test() {
		Vehicle v = new Vehicle();
		double direction = 0;
		assertEquals(direction, v.getDirection(), delta);
		direction = 3.5;
		v.setDirection(direction);
		assertEquals(direction, v.getDirection(), delta);

		double speed = 0;
		assertEquals(speed, v.getSpeed(), delta);
		speed = 50.1;
		v.setSpeed(speed);
		assertEquals(speed, v.getSpeed(), delta);
		
		String owner = null;
		assertEquals(owner, v.getOwner());
		owner = "hoge";
		v.setOwner(owner);
		assertEquals(owner, v.getOwner());
		
	}

}
