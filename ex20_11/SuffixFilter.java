import java.io.File;
import java.io.FileFilter;


public class SuffixFilter implements FileFilter {
	private final String suffix;

	SuffixFilter(String surfix) {
		this.suffix = surfix;
	}

	@Override
	public boolean accept(File f) {
		//System.out.println(f.getName() + " " + f.isFile() + " " + f.getName().endsWith(suffix));
		return f.isFile() && f.getName().endsWith(suffix); 
	}

}
