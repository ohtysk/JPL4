
public abstract class IncrementalBenchmark extends Benchmark {

	public final long[] incrementalRepeat(int count) {
		long[] spans = new long[count];
		for (int i = 0; i < count; i++) {
			spans[i] = repeat(i);
		}
		return spans;
	}
	
}
