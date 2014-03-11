import static org.junit.Assert.*;

import org.junit.Test;


public class PascalTest {

	@Test
	public void test1() {
		int depth = 12;
		Pascal pascal = new Pascal(depth);
		int[][] table = pascal.table;
		for (int i = 0; i < depth; i++) {
			assertEquals(1, table[i][0]);
			assertEquals(1, table[i][i]);
		}
		for (int y = 1; y < depth; y ++) {
			for (int x = 1; x < table[y].length - 1; x++) {
				assertEquals(table[y][x], table[y - 1][x - 1] + table[y - 1][x]);
			}
		}
		pascal.print(depth);
	}

	@Test
	public void test2() {
		int depth = 15;
		Pascal pascal = new Pascal(depth);
		int[][] table = pascal.table;
		for (int i = 0; i < depth; i++) {
			assertEquals(1, table[i][0]);
			assertEquals(1, table[i][i]);
		}
		for (int y = 1; y < depth; y ++) {
			for (int x = 1; x < table[y].length - 1; x++) {
				assertEquals(table[y][x], table[y - 1][x - 1] + table[y - 1][x]);
			}
		}
		pascal.print(depth);
	}

}
