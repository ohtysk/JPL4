import java.util.ArrayList;

public class ImprovedFibonacci {
	static final int MAX_SIZE = 25;
	static int index;
	//static Number[] numbers = new Number[MAX_SIZE];
	
	public static void main(String[] args) {
		//Number[] numbers = new Number[MAX_SIZE];
		//Number numbers = new Number();
		ArrayList<Number> numbers = new ArrayList<Number>();
		int lo = 2;
		int hi = 1;

		//numbers[MAX_SIZE - 1].setValue(lo);
		//numbers[0].setValue(lo);
		numbers.get(0).setValue(lo);
		System.out.println(numbers.get(0).toString());
		index = MAX_SIZE - 2;
		for (int i = MAX_SIZE - 1; i >= 0; i--) {
			//numbers[index].setValue(hi);
			hi = lo + hi;
			lo = hi - lo;
		}
		
		//System.out.println(numbers[0].toString());
	}
}
