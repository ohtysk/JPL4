import java.io.*;


public class MyUtilities {
	public double [] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;
		double[] data = null;
		try {
			in = new FileInputStream(file);
			data = readDataSet(in);
			return data;
		} catch (IOException e) {
			throw new BadDataSetException(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				throw new BadDataSetException(e, data);
			}
		}
	}

	private double[] readDataSet(FileInputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
}
