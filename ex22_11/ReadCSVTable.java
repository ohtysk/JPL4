import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;


public class ReadCSVTable {
	public static List<String[]> readCSVTable(Reader r, int cells) throws IOException {
		List<String[]> list = new ArrayList<String[]>();
		StreamTokenizer st = new StreamTokenizer(r);
/*		st.ordinaryChars('0', '9');
		st.ordinaryChar('+');
		st.ordinaryChar('-');
		st.ordinaryChar('.');
*/		st.whitespaceChars(',', ',');
		st.eolIsSignificant(true);
		int count = 0;
		String[] buf = new String[cells];
		while (st.nextToken() != StreamTokenizer.TT_EOF) {
			if (st.ttype == StreamTokenizer.TT_WORD || st.ttype == StreamTokenizer.TT_NUMBER) {
				if (count == 0) {
					buf = new String[cells];
					buf[count++] = (st.sval != null) ? st.sval : Double.toString(st.nval);
				} else if (count < cells) {
					buf[count++] = (st.sval != null) ? st.sval : Double.toString(st.nval);
				}
			} else if (st.ttype == StreamTokenizer.TT_EOL) {
				count = 0;
				list.add(buf);
			}
		}
		return list;
	}
}
