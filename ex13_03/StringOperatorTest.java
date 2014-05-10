import static org.junit.Assert.*;

import org.junit.Test;


public class StringOperatorTest {

	@Test
	public void testNormal() {
		String from = "<a><bb><ccc>";
		char start = '<';
		char end = '>';
		StringOperator so = new StringOperator();
		String[] delimited = so.delimitedString(from, start, end);
		assertEquals(3, delimited.length);
		assertEquals("<a>", delimited[0]);
		assertEquals("<bb>", delimited[1]);
		assertEquals("<ccc>", delimited[2]);
	}
	@Test
	public void testNothing() {
		String from = "<a<bb<ccc";
		char start = '<';
		char end = '>';
		StringOperator so = new StringOperator();
		String[] delimited = so.delimitedString(from, start, end);
		assertEquals(0, delimited.length);
	}

}
