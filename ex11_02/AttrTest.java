import static org.junit.Assert.*;

import org.junit.Test;


public class AttrTest {

	@Test
	public void test() {
		String name = "attr";
		String value = "value";
		Attr<String> attr = new Attr<String>(name);
		assertEquals(name, attr.getName());
		assertEquals(null, attr.getValue());
		attr.setValue(value);
		assertEquals(value, attr.getValue());
	}

}
