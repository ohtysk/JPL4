import static org.junit.Assert.*;

import org.junit.Test;


public class ColorAttrTest {

	@Test
	public void testHashCode1() {
		ColorAttr a = new ColorAttr("Yellow");
		ColorAttr b = new ColorAttr("Yellow");
		System.out.printf("%x %x\n", a.hashCode(), b.hashCode());
		assertEquals(a.hashCode(), b.hashCode());
		assertEquals(true, a.equals(b));
	}

	@Test
	public void testHashCode2() {
		ColorAttr a = new ColorAttr("Yellow");
		ColorAttr b = new ColorAttr("Green");
		System.out.printf("%x %x\n", a.hashCode(), b.hashCode());
		assertNotEquals(a.hashCode(), b.hashCode());
		assertEquals(false, a.equals(b));
	}
	
	@Test
	public void testConstructor1() {
		ColorAttr a = new ColorAttr("Yellow");
		assertEquals("Yellow='transparent'", a.toString());
	}

	@Test
	public void testConstructor2() {
		ColorAttr a = new ColorAttr("Yellow", "yellow");
		assertEquals("Yellow='yellow'", a.toString());
	}

	@Test
	public void testConstructor3() {
		ScreenColor c = new ScreenColor("YELLOW");
		ColorAttr a = new ColorAttr("Yellow", c);
		assertEquals("Yellow='YELLOW'", a.toString());
	}

}
