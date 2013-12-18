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
		LinkedList a = new LinkedList();
		a.value = "hoge";
		LinkedList b = new LinkedList();
		b.value = "huga";
		a.next = b;
		assertEquals("hoge", a.value);
		assertSame(b, a.next);
		assertEquals("huga", b.value);
		assertSame(null, b.next);
		assertEquals("huga", a.next.value);
		assertSame(null, a.next.next);
	}

}
