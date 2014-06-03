import java.util.Formattable;
import java.util.Formatter;


public class DoubleArray implements Formattable {
	private final double[] d;
	private final int column;
	private final int maxLineLength = 80;
	
	DoubleArray(double[] d, int column) {
		this.d = d;
		this.column = column;
	}

	@Override
	public void formatTo(Formatter formatter, int flag, int width, int precision) {
		int step = (maxLineLength + 1 - column) / column;
		String format = "%" + step + ".2f";
		for (int i = 0; i < d.length; i++) {
			if (i % column == column - 1) {
				formatter.format(format + "\n", d[i]);
			} else {
				formatter.format(format + " ", d[i]);
			}
		}
	}
	
}
