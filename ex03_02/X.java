
public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;
	
	{
		debugPrint(4);
	}
	
	public X() {
		fullMask = xMask;
		debugPrint(5);
	}
	
	public int mask(int orig) {
		return (orig & fullMask);
	}
	
	public void debugPrint(int step) {
		System.out.printf("step=%02d xMask=%04x fullMask=%04x\n", step, xMask, fullMask);
	}
}
