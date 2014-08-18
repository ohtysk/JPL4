import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;


public class ReadCSVTable {
	
	public static List<String[]> readCSVTable(Readable source, int cells) throws IOException {
		if (cells < 1) throw new InvalidParameterException();
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();
		String exp = "^([^,]*)";
		for (int i = 1; i < cells; i++)
			exp += ",([^,]*)";
		exp += "$";
		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cellsStr = new String[cells];
				MatchResult match = in.match();
				for (int i = 0; i < cells; i++) {
					cellsStr[i] = match.group(i + 1);
				}
				vals.add(cellsStr);
			} else {
				//throw new IOException("input format error");
			}
			if (in.hasNextLine()) in.nextLine();
		}
		
		IOException e = in.ioException();
		if (e != null) {
			throw e;
		}		return vals;
	}
}
