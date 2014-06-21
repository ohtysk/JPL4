import static org.junit.Assert.*;

import org.junit.Test;


public class SymbolTableTest {

	public static void main(String[] args) {
		new SymbolTableTest().test();
	}
	@Test
	public void test() {
		SymbolTable table = new SymbolTable();
		table.show();
	}

}
