import java.util.ArrayList;


public class StringOperator {
	String[] delimitedString(String from, char start, char end) {
		ArrayList<String> delimitd = new ArrayList<String>();
		int index = 0;
		while (index < from.length()) {
			index = from.indexOf(start, index);
			if (index < 0) break;
			
			int last = from.indexOf(end, index + 1);
			if (last < 0) break;
			
			delimitd.add(from.substring(index, last + 1));
			index = last + 1;
		}
		String[] ret = new String[delimitd.size()];
		for (int i = 0; i < delimitd.size(); i++)
			ret[i] = delimitd.get(i);
		return ret;
	}
}
