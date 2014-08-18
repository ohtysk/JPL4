import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.Test;


public class ReadCSVTableTest {
	private static int times = 100000;

	@Test
	public void test10() throws IOException {
		String exp = "^(.*),(.*),(.*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test11() throws IOException {
		String exp = "^(.*),(.*),(.*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test12() throws IOException {
		String exp = "^(.*),(.*),(.*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}

	@Test
	public void test20() throws IOException {
		String exp = "^([^,]*),([^,]*),([^,]*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test21() throws IOException {
		String exp = "^([^,]*),([^,]*),([^,]*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test22() throws IOException {
		String exp = "^([^,]*),([^,]*),([^,]*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test30() throws IOException {
		String exp = "^([a-z0-9 ]*),([a-z0-9 ]*),([a-z0-9 ]*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test31() throws IOException {
		String exp = "^([a-z0-9 ]*),([a-z0-9 ]*),([a-z0-9 ]*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test32() throws IOException {
		String exp = "^([a-z0-9 ]*),([a-z0-9 ]*),([a-z0-9 ]*)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test40() throws IOException {
		String exp = "^([^,]+),([^,]+),([^,]+)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test41() throws IOException {
		String exp = "^([^,]+),([^,]+),([^,]+)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}
	@Test
	public void test42() throws IOException {
		String exp = "^([^,]+),([^,]+),([^,]+)$";
		int cells = 3;
		File csv = new File("data.csv");
		FileReader in = new FileReader(csv);
		long start = System.currentTimeMillis();
		for (int i = 0; i < times; i++) {
			List<String[]> res = ReadCSVTable.readCSVTable(in, cells, exp);
		}
		int span = (int)(System.currentTimeMillis() - start);
		System.out.println("exp=\"" + exp + "\", span=" + span + "ms");
	}

}
