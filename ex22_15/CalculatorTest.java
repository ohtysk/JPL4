import static org.junit.Assert.*;

import org.junit.Test;


public class CalculatorTest {

	@Test
	public void testFree() throws Exception {
		double e = 0.00001;
		assertEquals(Math.cos(7 * (3 + 5.1)), Calculator.eval("5.1 3 + 7 * cos"), e);
	}
	
	@Test
	public void testBasic() throws Exception {
		double e = 0.00001;
		assertEquals(3 + 5.0, Calculator.eval("5 3 +"), e);
		assertEquals(3 - 5.0, Calculator.eval("5 3 -"), e);
		assertEquals(3 * 5.0, Calculator.eval("5 3 *"), e);
		assertEquals(3 / 5.0, Calculator.eval("5 3 /"), e);
		assertEquals(3 % 5.0, Calculator.eval("5 3 %"), e);
	}

	@Test
	public void testMath() throws Exception {
		double e = 0.00001;
		assertEquals(Math.sin(5), Calculator.eval("5 sin"), e);
		assertEquals(Math.cos(5), Calculator.eval("5 cos"), e);
		assertEquals(Math.tan(5), Calculator.eval("5 tan"), e);
		assertEquals(Math.asin(0.5), Calculator.eval("0.5 asin"), e);
		assertEquals(Math.acos(0.5), Calculator.eval("0.5 acos"), e);
		assertEquals(Math.atan(0.5), Calculator.eval("0.5 atan"), e);
		assertEquals(Math.atan2(5, 3), Calculator.eval("3 5 atan2"), e);
		assertEquals(Math.toRadians(0.5), Calculator.eval("0.5 toRadians"), e);
		assertEquals(Math.toDegrees(0.5), Calculator.eval("0.5 toDegrees"), e);
		assertEquals(Math.exp(0.5), Calculator.eval("0.5 exp"), e);
		assertEquals(Math.sinh(0.5), Calculator.eval("0.5 sinh"), e);
		assertEquals(Math.cosh(0.5), Calculator.eval("0.5 cosh"), e);
		assertEquals(Math.tanh(0.5), Calculator.eval("0.5 tanh"), e);
		assertEquals(Math.pow(5, 3), Calculator.eval("3 5 pow"), e);
		assertEquals(Math.log(0.5), Calculator.eval("0.5 log"), e);
		assertEquals(Math.log10(0.5), Calculator.eval("0.5 log10"), e);
		assertEquals(Math.sqrt(0.5), Calculator.eval("0.5 sqrt"), e);
		assertEquals(Math.cbrt(0.5), Calculator.eval("0.5 cbrt"), e);
		assertEquals(Math.signum(0.5), Calculator.eval("0.5 signum"), e);
		assertEquals(Math.ceil(0.5), Calculator.eval("0.5 ceil"), e);
		assertEquals(Math.floor(0.5), Calculator.eval("0.5 floor"), e);
		assertEquals(Math.rint(0.5), Calculator.eval("0.5 rint"), e);
		assertEquals(Math.round(0.5), Calculator.eval("0.5 round"), e);
		assertEquals(Math.abs(0.5), Calculator.eval("0.5 abs"), e);
		assertEquals(Math.max(5, 3), Calculator.eval("3 5 max"), e);
		assertEquals(Math.min(5, 3), Calculator.eval("3 5 min"), e);
		assertEquals(Math.hypot(5, 3), Calculator.eval("3 5 hypot"), e);
	}
}
