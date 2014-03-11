
public class Pascal {
	final int [][] table;
	final int depth;
	final int DefaultDepth = 12;
	final int MinimumDepth = 1;
	
	Pascal(int depth) {
		if (MinimumDepth < depth) {
			this.depth = depth;
		} else {
			this.depth = DefaultDepth;
		}
		table = new int [this.depth][];
		for (int i = 0; i < this.depth; i++) {
			table[i] = new int[i + 1];
		}
		init();
	}
	
	private void init() {
		table[0][0] = 1;
		for (int y = 1; y < depth; y++) {
			for (int x = 0; x < table[y].length; x++) {
				int prevLeft;
				if (x == 0) {
					prevLeft = 0;
				} else {
					prevLeft = table[y - 1][x - 1];
				}
				int prevRight;
				if (x == y) {
					prevRight = 0;
				} else {
					prevRight = table[y - 1][x];
				}
				table[y][x] = prevLeft + prevRight;  
			}
		}
	}
	
	public void print(int depth) {
		if (depth < MinimumDepth) {
			depth = MinimumDepth;
		} else if (this.depth < depth) {
			depth = this.depth;
		}
		for (int y = 0; y < depth; y++) {
			System.out.print(table[y][0]);
			for (int x = 1; x < table[y].length; x++ ) {
				System.out.print(" " + table[y][x]);				
			}
			System.out.printf("%n");
		}
	}
}
