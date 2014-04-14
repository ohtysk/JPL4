
public class Sequence {
	public static void showSequence(char from, char to) {
		if (from < to) {
			for (char target = from; target <= to; target++)
				System.out.print(target);
		} else {
			for (char target = from; target >= to; target--)
				System.out.print(target);			
		}
		System.out.println();
	}
}
