
public class CallThread implements Runnable {
	private final int addValue;
	private final int spanMsec;

	CallThread(int addValue, int spanMsec) {
		this.addValue = addValue;
		this.spanMsec = spanMsec;
	}
	
	public void run() {
		for (int i = 0; i < 9; i++) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			SynchronizedObject.addAndPrint(addValue);
		}
	}	
}
