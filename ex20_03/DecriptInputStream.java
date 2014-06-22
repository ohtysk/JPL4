import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecriptInputStream extends FilterInputStream {

	protected DecriptInputStream(InputStream is) {
		super(is);
	}

	public int read() throws IOException {
		return (byte)(super.read() - 1);
	}
	
	public int read(byte[] buf, int off, int len) throws IOException {
		int c = super.read(buf, off, len);
		for (int i = 0; i < len; i++)
			buf[off + i]--;
		return c;
	}
}
