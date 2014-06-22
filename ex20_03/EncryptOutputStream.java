import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class EncryptOutputStream extends FilterOutputStream {

	public EncryptOutputStream(OutputStream os) {
		super(os);
	}
	
	@Override
	public void write(int b) throws IOException {
		super.write((byte)(b + 1));
	}
}
