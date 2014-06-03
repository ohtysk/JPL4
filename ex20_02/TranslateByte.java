import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TranslateByte extends FilterInputStream {
	private final byte from;
	private final byte to;

	protected TranslateByte(InputStream in, byte from, byte to) {
		super(in);
		this.from = from;
		this.to = to;
	}

	public int read() throws IOException {
		int c = super.read();
		return c == from ? to : c;
	}
	
	public int read(byte[] b) throws IOException {
		int total = super.read(b);
		for (int i = 0; i < total; i++) {
			byte c = b[i];
			if (c == from) {
				b[i] = to;
			}
		}			
		return total;
	}
}
