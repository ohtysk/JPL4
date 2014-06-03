import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;


public class DoubleArrayTest {

	@Test
	public void test() {
		int length = 100;
		Random r = new Random();
		double[] array = new double[length];
		for (int i = 0; i < length; i++)
			array[i] = r.nextDouble() * r.nextInt();
		
		DoubleArray da = new DoubleArray(array, 5);
		System.out.printf("%s\n", da);
	}

	@Test
	public void test2() {
		int length = 100;
		Random r = new Random();
		double[] array = new double[length];
		for (int i = 0; i < length; i++)
			array[i] = r.nextDouble() * r.nextInt();
		
		DoubleArray da = new DoubleArray(array, 4);
		System.out.printf("%s\n", da);
	}

}
