/*
 * ����̗�ł̓��[�v�����ȏ゠�邱�Ƃ��ۏႳ��Ă���̂�do-while�ɂ��邱�Ƃ��ł���B
 * �����z��̒����������[�v���񂷍ۂɂ͔z��̒������O�łȂ����Ƃ��m���߂Ȃ���do-while�͎g���Ȃ� 
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
