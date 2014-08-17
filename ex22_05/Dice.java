import java.util.Random;


public class Dice {
	private static Random r = new Random(); 
	
	public static int nextValue() {
		return r.nextInt(6) + 1;
	}
}
