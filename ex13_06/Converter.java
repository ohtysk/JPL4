
public class Converter {
	public String convert(String input, String delim, int step) {
		int length = input.length();
		int end = length % step;
		StringBuilder buf = new StringBuilder();

		for (int start = 0; end <= length; start = end, end += step) {
			if (end == 0) continue;
			buf.append(input.substring(start, end));
			if (end < length) buf.append(delim);
		}
		
		return buf.toString();
	}
}
