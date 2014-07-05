import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;


public class NameOpValue {
	private final static String[] names = {"Name1", "Name2", "Name3"};
	private enum OP {PLUS, MINUS, EQUAL};
	public double[] values = {0, 0, 0};
	
	public void parseApply(Reader source) throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		int nameIndex = -1;
		OP op = null;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			switch(in.ttype) {
			case StreamTokenizer.TT_WORD:
				if (nameIndex == -1) {
					String name = in.sval;
					for (int i = 0; i < names.length; i++) {
						if (name.equals(names[i])) {
							nameIndex = i;
							break;
						}
					}
					if (nameIndex != -1) {
						break;
					}
					throw new IOException("wrong name!");
				}
				throw new IOException("double name!");
			case '+':
				if (op == null) {
					op = OP.PLUS;
					break;
				}
				throw new IOException("double op!");				
			case '-':
				if (op == null) {
					op = OP.MINUS;
					break;
				}
				throw new IOException("double op!");				
			case '=':
				if (op == null) {
					op = OP.EQUAL;
					break;
				}
				throw new IOException("double op!");				
			case StreamTokenizer.TT_NUMBER:
				if (nameIndex != -1 && op != null) {
					apply(nameIndex, op, in.nval);
					nameIndex = -1;
					op = null;
					break;
				}
				throw new IOException("syntax error!");				
			default:
				throw new IOException("syntax error!");				
			}
		}
		printAll();
	}
	
	private void apply(int nameIndex, OP op, double value) {
		switch(op) {
		case PLUS:
			values[nameIndex] += value;
			break;
		case MINUS:
			values[nameIndex] -= value;
			break;
		case EQUAL:
			values[nameIndex] = value;
			break;
		default:
			break;
		}
	}
	
	private void printAll() {
		for (int i = 0; i < 3; i++) {
			System.out.println(names[i] + " = " + values[i]);
		}
	}
}
