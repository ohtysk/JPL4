import static org.junit.Assert.*;

import org.junit.Test;


public class TypeDescTest {

	@Test
	public void test() {
		String[] args = { "java.util.HashMap", "java.awt.Color" };
		TypeDesc.main(args);
	}

}
