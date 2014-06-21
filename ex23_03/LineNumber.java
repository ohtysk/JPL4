import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class LineNumber {
	public final String word;
	
	LineNumber(String word) {
		this.word = word;
	}
	
	void exec(String cmd) throws IOException {
		System.out.println("command :" + cmd);
		Process child = Runtime.getRuntime().exec(cmd);
		InputStream isOut = child.getInputStream();
		InputStreamReader r = new InputStreamReader(isOut);
		BufferedReader in = new BufferedReader(r);

		String line;
		int i = 0;
		while ((line = in.readLine()) != null) {
			if (line.matches(word)) {
				child.destroy();
				break;
			}
			System.out.println(i++ + " : " + line);
		}
	}
	
	// test) java LineNumber 'yes' 'ls' 'pwd'
	public static void main(String[] args) throws IOException {
		LineNumber ln = new LineNumber("y");
		for (String arg : args) {
			ln.exec(arg);
		}
	}
}
