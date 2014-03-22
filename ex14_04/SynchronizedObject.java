
public class SynchronizedObject {
	static int value = 0;

	static synchronized void addAndPrint(int other) {
		value += other;
		System.out.println(value);
	}
}
