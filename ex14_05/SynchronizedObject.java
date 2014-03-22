
public class SynchronizedObject {
	int value = 999999;
	private final Object lock = new Object();

	void subAndPrint(int other) {
		synchronized (lock) {
			value -= other;
			System.out.println(value);
		}
	}
}
