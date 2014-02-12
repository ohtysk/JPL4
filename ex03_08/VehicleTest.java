import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class VehicleTest {

	@Test
	public void testClone() {
		double delta = 0.001;
		Vehicle v1 = new Vehicle("hoge");
		v1.setDirection(0.5);
		v1.setSpeed(1);
		Vehicle v2 = v1.clone();
		assertEquals(null, v2.getFirstOwner());
		assertEquals(0, v2.getDirection(), delta);
		assertEquals(0, v2.getSpeed(), delta);
		assertNotEquals(v1.getId(), v2.getId());
	}

}
