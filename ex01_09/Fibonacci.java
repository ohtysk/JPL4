
public class Fibonacci {
	static final int MAX_SIZE = 20;
	static int[] numbers = new int[MAX_SIZE];
	static int index;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Fibonacci");
		numbers[0] = 1;
		numbers[1] = 1;
		index = 2;
		while (index < MAX_SIZE) {
			numbers[index] = numbers[index - 1] + numbers[index - 2];
			index++;
		}
		
		System.out.println(numbers[MAX_SIZE - 1]);
	}

}
