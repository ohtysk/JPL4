
public class Y extends X {
	protected static int yMask = 0xff00;
	
	{
		System.out.printf("xMask=%04x fullMask=%04x yMask=%04x\n", xMask, fullMask, yMask);
	}
	
	public Y() {
		System.out.printf("xMask=%04x fullMask=%04x yMask=%04x\n", xMask, fullMask, yMask);
		fullMask |= yMask;
		System.out.printf("xMask=%04x fullMask=%04x yMask=%04x\n", xMask, fullMask, yMask);
		System.out.printf("%04x\n", mask(0xffff));
	}
	
	public static void main(String args[]) {
		Y y = new Y();
	}
	
	public int mask(int orig) {
		return (orig & yMask);
	}
}
