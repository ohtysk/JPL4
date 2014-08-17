import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class WhichChars {
	Map<BitSet, BitSet> used = new HashMap<BitSet, BitSet>();
	
	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			int code = str.codePointAt(i);
			BitSet upper = new BitSet();
			upper.set(code >> 24);
			if (used.containsKey(upper)) {
				BitSet downer = used.get(upper);
				downer.set(code % (2 << 24));
			} else {
				BitSet downer = new BitSet();
				downer.set(code % (2 << 24));
				used.put(upper, downer);
			}
		}
	}
	
	public String toString() {
		String desc = "[";
		for (Entry<BitSet, BitSet> e : used.entrySet()) {
			int uppercode = e.getKey().nextSetBit(0) << 24;
			for (int downercode = e.getValue().nextSetBit(0);
					downercode >= 0;
					downercode = e.getValue().nextSetBit(downercode + 1)) {
				desc += (char)(uppercode + downercode);
			}
		}
		return desc += "]";
	}
}
