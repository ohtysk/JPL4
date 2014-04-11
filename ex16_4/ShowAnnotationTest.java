import static org.junit.Assert.*;

import org.junit.Test;


public class ShowAnnotationTest {

	@Test
	public void test() {
		ShowAnnotation.show("ShowAnnotationTest");
	}

	@Test
	public void test2() {
		ShowAnnotation.show("java.lang.reflect.Field");
	}

}
