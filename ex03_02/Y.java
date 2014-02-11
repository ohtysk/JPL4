
public class Y extends X {
	protected int yMask = 0xff00;
	
	{
		debugPrint(6);
	}
	
	public Y() {
		fullMask |= yMask;
		debugPrint(7);
	}
	
	public static void main(String args[]) {
		Y y = new Y();
	}
	
	public void debugPrint(int step) {
		System.out.printf("step=%02d xMask=%04x yMask=%04x fullMask=%04x\n", step, xMask, yMask, fullMask);
	}
}
