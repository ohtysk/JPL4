import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LinkedListTest {

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
		final int VEHICLE_NUMBER = 10;
		LinkedList []vehicles = new LinkedList[VEHICLE_NUMBER];
		for (int i = 0; i < VEHICLE_NUMBER; i++) {
			Vehicle v = new Vehicle();
			v.setSpeed(i * 0.7);
			v.setDirection(i * 1.7);
			v.setOwner("owner" + i);
			vehicles[i] = new LinkedList(v);
			if (i > 0) {
				vehicles[i].next = vehicles[i - 1];
			}
		}
		LinkedList target = vehicles[VEHICLE_NUMBER - 1];
		int i = VEHICLE_NUMBER - 1;
		double delta = 0.01;
		while (target.next != null) {
			Vehicle v = (Vehicle)target.value;
			assertEquals(i, v.getId());
			assertEquals(i * 0.7, v.getSpeed(), delta);
			assertEquals(i * 1.7, v.getDirection(), delta);
			assertEquals("owner" + i, v.getOwner());
			i--;
			target = target.next;
		}
	}

}
