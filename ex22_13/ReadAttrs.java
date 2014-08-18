import java.io.IOException;
import java.io.Reader;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

import sun.misc.Regexp;


public class ReadAttrs {
	public static Map<String, Object> readAttrs(Reader r) throws IOException {
		Map<String, Object> map = new TreeMap<String, Object>();
		Scanner in = new Scanner(r);
		String str = "^([^=]*?)=([^=]*)$";
		Pattern pat = Pattern.compile(str, Pattern.MULTILINE);
		while(in.hasNext()) {
			String match = in.findInLine(pat);
			if (match != null) {
				MatchResult res = in.match();
				map.put(res.group(1), res.group(2));
			} else {
				throw new IOException("wrong format");
			}
			if (in.hasNext()) in.nextLine();
		}
		return map;
	}
}
