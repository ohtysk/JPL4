import java.io.*;


public class MyUtilities {
	public double [] getDataSet(String setName) throws BadDataSetException {
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException(e);
		} finally {
			try {
				if (in != null)
					in.close();
			} catch (IOException e) {
				;
			}
		}
	}

	private double[] readDataSet(FileInputStream in) {
		// TODO Auto-generated method stub
		return null;
	}
}
