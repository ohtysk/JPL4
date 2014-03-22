
public class SynchronizedObject {
	int value = 0;
	private final Object lock = new Object();

	void addAndPrint(int other) {
		synchronized (lock) {
			value += other;
			System.out.println(value);
		}
	}
}
