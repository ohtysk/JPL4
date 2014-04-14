/*
 * 今回の例ではループが一回以上あることが保障されているのでdo-whileにすることができる。
 * もし配列の長さだけループを回す際には配列の長さが０でないことを確かめないとdo-whileは使えない 
*/
public class BitCount {
	public static int bitCount(int value) {
		int count = 0;
		int i = 0;
		do {
			if ((value & 0x0001) == 0x0001) count++;
			i++;
			value >>= 1;
		} while (i < 32);
		/*
		int i = 0;
		while (i < 32) {
			if ((value & 0x0001) == 0x0001) count++;
			i++;
			value >>= 1;
		}
		*/
		/*
		for (int i = 0; i < 32; i++) {
			if ((value & 0x0001) == 0x0001) count++;
			value >>= 1;
		}
		*/
		return count;
	}
	
	public static String bitString(int value) {
		String bits = "";
		// while
		int i = 0;
		while (i < 32) {
			bits += (value & 0x80000000) == 0x80000000 ? "1" : "0";
			i++;
			value <<= 1;
		}
		/*
		for (int i = 0; i < 32; i++) {
			if ((value & 0x80000000) == 0x80000000) {
				bits += "1";
			} else {
				bits += "0"; 
			}
			value <<= 1;
		}
		*/
		return bits;
	}
}
