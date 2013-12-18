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
		double delta = 0.001;
		for (int i = 0; i < 15; i++) {
			Vehicle v = new Vehicle("first owner " + i);
			v.setSpeed(i * 0.5);
			assertEquals(i * 0.5, v.getSpeed(), delta);
			v.changeSpeed(i * 2.5);
			assertEquals(i * 2.5, v.getSpeed(), delta);
			v.stop();
			assertEquals(0, v.getSpeed(), delta);			
		}
	}

}
