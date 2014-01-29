
public class Y extends X {
	protected int yMask = 0xff00;
	
	{
		System.out.printf("xMask=%04x fullMask=%04x yMask=%04x\n", xMask, fullMask, yMask);
	}
	
	public Y() {
		System.out.printf("xMask=%04x fullMask=%04x yMask=%04x\n", xMask, fullMask, yMask);
		fullMask |= yMask;
		System.out.printf("xMask=%04x fullMask=%04x yMask=%04x\n", xMask, fullMask, yMask);
	}
	
	public static void main(String args[]) {
		Y y = new Y();
	}
}
