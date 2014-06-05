import static org.junit.Assert.*;

import org.junit.Test;


public class ResourceImplTest {

	@Test
	public void test1() {
		Object key1 = new Object();
		ResourceImpl ri = new ResourceImpl(key1);
		ri.use(key1);
	}

	@Test
	public void test2() {
		Object key1 = new Object();
		ResourceImpl ri = new ResourceImpl(key1);
		Object key2 = new Object();
		try {
			ri.use(key2);
			fail("");
		} catch (IllegalArgumentException e) {
		}
	}

}
