
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	{
		System.out.printf("xMask=%04x fullMask=%04x\n", xMask, fullMask);
	}
	
	public X() {
		System.out.printf("xMask=%04x fullMask=%04x\n", xMask, fullMask);
		fullMask = xMask;
		System.out.printf("xMask=%04x fullMask=%04x\n", xMask, fullMask);
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}
}
