import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class IgnoreComment {
	private static String LINE_SEPARATOR = "\r\n|[\n\r\u2028\u2029\u0085]";
	public static List<String> getToken(Readable r) {
		List<String> ret = new ArrayList<String>();
		Scanner in = new Scanner(r);
		String pat = "#.*";
		in.useDelimiter(in.delimiter() + "|" + pat + "|" + LINE_SEPARATOR);
		while (in.hasNext()) {
			String next = in.next();
			if (next.length() != 0) {
				ret.add(next);
			}
		}
		return ret;
	}
}
