import static org.junit.Assert.*;

import org.junit.Test;


public class SortHarnessDoubleTest {

	@Test
	public void test() {
		Double[] testData = {0.0, 1.3e-2, 7.9, 3.17};
		SortHarness<Double> sort = new SortHarnessDouble();
		SortMetrics metrics = sort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
		
		
	}

}
