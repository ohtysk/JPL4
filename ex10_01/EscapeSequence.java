
public class EscapeSequence {
	public static String escape(String string) {
		String escaped = "";
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c == '\n') {
				escaped += "\\n";
			} else if (c == '\t') {
				escaped += "\\t";
			} else if (c == '\b') {
				escaped += "\\b";
			} else if (c == '\r') {
				escaped += "\\r";
			} else if (c == '\f') {
				escaped += "\\f";
			} else if (c == '\\') {
				escaped += "\\\\";
			} else if (c == '\'') {
				escaped += "\\'";
			} else if (c == '\"') {
				escaped += "\\\"";
			} else if (c == '\b') {
				escaped += "\\b";
			} else {
				escaped += c;
			}
		}
		return escaped;
	}
}
