
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.WeakHashMap;


public class DataHandler {
	private Map<File, byte[]> cash = new WeakHashMap<File, byte[]>();

	public byte[] readFile(File file) throws IOException {
		cash.remove(null);
		byte[] data = cash.get(file);
		if (data == null) {
			data = readBytesFromFile(file);
			cash.put(file, data);
		}
		return data;
	}

	private byte[] readBytesFromFile(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		int length = fis.available();
		byte[] data = new byte[length];
		fis.read(data);
		return data;
	}
}