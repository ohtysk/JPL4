import java.util.Arrays;

public class SortAndCrack extends SortDouble {
	@Override
	protected void doSort() {
		// TODO Auto-generated method stub
		int length = getDataLength();
		double[] data = new double[length];
		for (int i = 0; i < length; i++) {
			data[i] = probe(i);
		}
		double[] sorted = data.clone();
		Arrays.sort(sorted);
		
		nextSortedIndex:
		for (int sortedIndex = 0; sortedIndex < length; sortedIndex++) {
			for (int dataIndex = 0; dataIndex < length; dataIndex++) {
				if (sorted[sortedIndex] == data[dataIndex]) {
					if (sortedIndex != dataIndex) {
						swap(sortedIndex, dataIndex);
						data[dataIndex] = data[sortedIndex];
						data[sortedIndex] = sorted[sortedIndex];
					}
					break nextSortedIndex;
				}
			}
		}
	}
}
