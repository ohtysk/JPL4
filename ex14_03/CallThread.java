
public class CallThread implements Runnable {
	private final SyncronisedObject object;
	private final int addValue;
	private final int spanMsec;

	CallThread(SyncronisedObject object, int addValue, int spanMsec) {
		this.object = object;
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
			object.addAndPrint(addValue);
		}
	}	
}
