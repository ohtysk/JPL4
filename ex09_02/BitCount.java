
public class BitCount {
	public static int bitCount(int value) {
		int count = 0;
		for (int i = 0; i < 32; i++) {
			if ((value & 0x0001) == 0x0001) count++;
			value >>= 1;
		}
		return count;
	}
	
	public static String bitString(int value) {
		String bits = "";
		for (int i = 0; i < 32; i++) {
			if ((value & 0x80000000) == 0x80000000) {
				bits += "1";
			} else {
				bits += "0"; 
			}
			value <<= 1;
		}
		return bits;
	}
}
