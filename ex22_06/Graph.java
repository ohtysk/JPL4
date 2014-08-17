import java.util.Random;


public class Graph {
	public static void main(String[] args) {
		Random r = new Random();
		int times = 1000000;
		int step = 12;
		int scale = 10;
		int shift = 40;
		int[] count = new int [shift * 2];
		for (int i = 0; i < times; i++) {
			double val = r.nextGaussian();
			int pos = (int)Math.floor(val * scale) + shift;
			pos = Math.max(Math.min(pos, 79), 0);
			count[pos]++;
		}
		int max = 0;
		for (int i = 0; i < 80; i++) {
			max = Math.max(count[i], max);
			//System.out.println(i + " " + count[i]);
		}
		int span = max / step;
		
		for (int i = 0; i < step + 1; i++) {
			for (int j = 0; j < 80; j++) {
				if (count[j] > span * (step + 1 - i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < 80; i++) {
			System.out.print("-");
		}
	}
}
