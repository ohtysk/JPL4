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
		LinkedList a = new LinkedList("hoge", "huga", "test");
		assertEquals(3, a.length());

		LinkedList b = new LinkedList("aaaa");
		assertEquals(1, b.length());

		LinkedList c = new LinkedList((Object[]) new String[] {"111", "222", null, "444"});
		assertEquals(4, c.length());

		LinkedList d = new LinkedList("bbb", c);
		assertEquals(5, d.length());
	}

}
