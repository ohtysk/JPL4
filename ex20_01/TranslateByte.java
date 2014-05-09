import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class TranslateByte {
	public static void main(String[] args) {
		TranslateByte tb = new TranslateByte();
		try {
			tb.setStream(System.in, System.out, (byte)'b', (byte)'B');
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setStream(InputStream is, OutputStream os, byte from, byte to) throws IOException {
		int b;
		while ((b = is.read()) != -1) {
			os.write(b == from ? to : b);
		}
	}
}
