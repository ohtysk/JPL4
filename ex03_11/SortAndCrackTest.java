import static org.junit.Assert.*;

import org.junit.Test;


public class SortAndCrackTest {

	@Test
	public void test() {
		double[] testData = {0.3, 1.3e-2, 7.9, 3.17};
		SortDouble sort = new SortAndCrack();
		SortMetrics metrics = sort.sort(testData);
		System.out.println("Metrics: " + metrics);
		for (int i = 0; i < testData.length; i++) {
			System.out.println("\t" + testData[i]);
		}
	}

}
