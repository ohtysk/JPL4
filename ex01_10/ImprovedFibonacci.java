
public class ImprovedFibonacci {
	static final int MAX_SIZE = 25;
	static Number[] numbers = new Number[MAX_SIZE];
	
	public static void main(String[] args) {
		int lo = 1;
		int hi = 1;

		numbers[0] = new Number(lo);
		for (int i = 1; i < MAX_SIZE; i++) {
			numbers[i] = new Number(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
		
		for (int i = 0; i < MAX_SIZE; i++) {
			System.out.println((i + 1) + ": " + numbers[i]);
		}
	}
}
