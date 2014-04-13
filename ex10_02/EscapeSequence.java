
public class EscapeSequence {
	public static String escape(String string) {
		String escaped = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			switch(c) {
				case '\n':
					escaped += "\\n";
					break;
				case '\t':
					escaped += "\\t";
					break;
				case '\b':
					escaped += "\\b";
					break;
				case '\r':
					escaped += "\\r";
					break;
				case '\f':
					escaped += "\\f";
					break;
				case '\\':
					escaped += "\\\\";
					break;
				case '\'':
					escaped += "\\'";
					break;
				case '\"':
					escaped += "\\\"";
					break;
				default:
					escaped += c;
					break;
			}
		}
		return escaped;
	}
}
