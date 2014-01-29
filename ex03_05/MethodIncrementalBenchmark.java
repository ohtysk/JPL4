
public class MethodIncrementalBenchmark extends IncrementalBenchmark {

	@Override
	void benchmark() {
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 500;
		long[] times = new MethodIncrementalBenchmark().incrementalRepeat(count);
		for (int i = 0; i < times.length; i++) {
			System.out.printf("%d times in %d nanosecond\n", i, times[i]);
		}
	}

}
