
public class PrintServer implements Runnable {
	private final Thread initialThread;
	private final PrintQueue requests = new PrintQueue();
	
	PrintServer() {
		initialThread = new Thread(this);
		initialThread.start();
	}
	
	public void print(PrintJob job) {
		requests.add(job);
	}
	
	@Override
	public void run() {
		if (initialThread != Thread.currentThread()) {
			System.out.println("initialThread != currentThread");
			return;
		}
		
		System.out.println("initialThread == currentThread");
		
		for (;;)
			realPrint(requests.remove());
					
	}
	
	private void realPrint(PrintJob remove) {}
}
