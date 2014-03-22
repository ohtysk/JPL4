
public class SynchronizedObject {
	int value = 0;

	synchronized void addAndPrint(int other) {
		value += other;
		System.out.println(value);
	}
	/*
	void addAndPrint(int other) {
		value += other;
		System.out.println(value);
	}
	*/
}
