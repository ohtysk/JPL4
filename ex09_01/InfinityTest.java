
public class InfinityTest {
	public static void main(String[] args) {
		Double pi = Double.POSITIVE_INFINITY;
		Double ni = Double.NEGATIVE_INFINITY;
		
		// +
		System.out.println("pi + pi = " +  (pi + pi));
		System.out.println("pi + ni = " +  (pi + ni));
		System.out.println("ni + pi = " +  (ni + pi));
		System.out.println("ni + ni = " +  (ni + ni));

		// -
		System.out.println("pi - pi = " +  (pi - pi));
		System.out.println("pi - ni = " +  (pi - ni));
		System.out.println("ni - pi = " +  (ni - pi));
		System.out.println("ni - ni = " +  (ni - ni));

		// *
		System.out.println("pi * pi = " +  (pi * pi));
		System.out.println("pi * ni = " +  (pi * ni));
		System.out.println("ni * pi = " +  (ni * pi));
		System.out.println("ni * ni = " +  (ni * ni));
		
		// /
		System.out.println("pi / pi = " +  (pi / pi));
		System.out.println("pi / ni = " +  (pi / ni));
		System.out.println("ni / pi = " +  (ni / pi));
		System.out.println("ni / ni = " +  (ni / ni));
	}
}
