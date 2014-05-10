
public class Converter {
	public String convert(String input) {
		int length = input.length();
		int end = length % 3;
		int step = 3;
		String delim = ",";
		StringBuilder buf = new StringBuilder();

		for (int start = 0; end <= length; start = end, end += step) {
			buf.append(input.substring(start, end));
			if (end < length) buf.append(delim);
		}
		
		return buf.toString();
	}
}
