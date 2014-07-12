import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;


public class Word {
	Map<String, Integer> map = new HashMap<String, Integer>();
	public void readFile(File f) throws IOException {
		Reader r = new FileReader(f);
		StreamTokenizer in = new StreamTokenizer(r);
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_WORD) {
				String word = in.sval;
				if (map.containsKey(word)) {
					Integer value = map.get(word);
					map.put(word, value + 1);
				} else {
					map.put(word, 1);
				}
			}
		}
	}
	
	public void showMap() {
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			Integer value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}
	
}
