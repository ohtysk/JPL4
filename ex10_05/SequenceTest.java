import static org.junit.Assert.*;

import org.junit.Test;


public class SequenceTest {

	@Test
	public void test() {
		Sequence.showSequence('a', 'z');
		Sequence.showSequence('z', '5');
		Sequence.showSequence('5', 'z');
		Sequence.showSequence('‚¨', '‚ ');
		Sequence.showSequence('‚ ', '‚¿');
	}

}
