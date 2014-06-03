import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;


public class LineFilterReader extends FilterReader {
	public LineFilterReader(Reader arg0) {
		super(arg0);
	}

	public int read() throws IOException {
		return super.read();
	}
	
	public int read(char[] cbuf, int off, int len) throws IOException {
		int c;
		int target = 0;

		while ((c = super.read()) != -1) {
			cbuf[off + target] = (char)c;
			target++;
			if (c == '\n' || target == len) break;
		}
		if (c == -1) return -1;
		return target;
	}
}