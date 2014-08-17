import static org.junit.Assert.*;

import org.junit.Test;


public class DiceTest {

	@Test
	public void test() {
		int number = 3;
		int times = 10000000;
		int length = 6 * number + 1;
		int[] count = new int[length];
		for (int i = 0; i < times; i++) {
			int sum = 0;
			for (int j = 0; j < number; j++) {
				sum += Dice.nextValue();
			}
			count[sum]++;
		}
		
		
		System.out.println("number=" + number + ", times=" + times);
		for (int i = number; i < length; i++) {
			double rate = count[i] * 100 / (double) times;
			System.out.println("sum=" + i + ", rate=" + rate + "%");
		}
	}

}
