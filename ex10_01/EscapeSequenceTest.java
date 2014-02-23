import static org.junit.Assert.*;

import org.junit.Test;


public class EscapeSequenceTest {

	@Test
	public void test() {
		assertEquals("a\\nb", EscapeSequence.escape("a\nb"));
		assertEquals("a\\tb", EscapeSequence.escape("a\tb"));
		assertEquals("a\\bb", EscapeSequence.escape("a\bb"));
		assertEquals("a\\rb", EscapeSequence.escape("a\rb"));
		assertEquals("a\\fb", EscapeSequence.escape("a\fb"));
		assertEquals("a\\\\b", EscapeSequence.escape("a\\b"));
		assertEquals("a\\\'b", EscapeSequence.escape("a\'b"));
		assertEquals("a\\\"b", EscapeSequence.escape("a\"b"));
	}

}
