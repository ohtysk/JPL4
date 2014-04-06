
public class ThreadGroupWatcher {
	ThreadGroupWatcher(final ThreadGroup threadGroup, final long millis, final String prefix) {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					show(threadGroup, prefix);
					try {
						Thread.sleep(millis);
					} catch (InterruptedException e) {}
				}
			}
		}).start();
	}
		
	private void show(ThreadGroup threadGroup, String prefix) {
		Thread[] threads = new Thread[100];
		int threadLength = threadGroup.enumerate(threads);
		
		for (int i = 0; i < threadLength; i++) {
			showThread(threads[i], prefix);
		}
	}

	private static synchronized void showThread(Thread thread, String prefix) {
		System.out.println(prefix + getFullPath(thread));
	}
	
	private static String getFullPath(Thread thread) {
		String fullPath = thread.getName();
		ThreadGroup group = thread.getThreadGroup();
		while (group != null) {
			fullPath = group.getName() + "/" + fullPath;
			group = group.getParent();
		}
		return fullPath;
	}
}
