import static org.junit.Assert.*;

import org.junit.Test;


public class SimpleSortHarnesTest {

	@Test
	public void test() {
		Object[] testData = {"a", "ab", 1.3e-2, 7.9, 3.17, "z", "b", "aa"};
		SortHarness sort = new SimpleSortHarnes();
		SortMetrics metrics = sort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}

}
