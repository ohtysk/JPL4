import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;


public class Grep {
	public static void main(String[] args) throws IOException {
		if (args.length != 2) return;
		
		File file = new File(args[0]);
		String target = args[1];
		
		FileReader reader = new FileReader(file);
		LineNumberReader lnr = new LineNumberReader(reader);
		int lastLine = 1;
		lnr.setLineNumber(lastLine);
		int c;
		String buf = "";
		while ((c = lnr.read()) != -1) {
			if (c == '\n' || c == '\r') continue;
			int line = lnr.getLineNumber();
			if (line == lastLine) {
				buf += Character.toString((char)c);				
				continue;
			}

			if (buf.indexOf(target) != -1) {
				showLine(lastLine, buf);
			}
			buf = Character.toString((char)c);
			lastLine = line;
		}
		if (buf.indexOf(target) != -1) {
			showLine(lastLine, buf);
		}		
	}
	
	private static void showLine(int line, String msg) {
		System.out.println(line + " : " + msg);
	}
}
