import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;


public class ArrayBunchListTest {

	@Test
	public void test() {
		String [][] data = {
				{"a", "b", "c", "d"}, 
				{"e", "f", "g", "h"},
				{"i", "j", "k", "l"},
				{"m", "n", "o", "p"}};
		List<String> list = new ArrayList<String>();
		for (String[] d : data)
			list.addAll(Arrays.asList(d));
		
		ArrayBunchList<String> abl = new ArrayBunchList<String>(data);
		ListIterator<String> it = abl.iterator();
		
		for (int i = 0; i < list.size(); i++) {
			assertEquals(i - 1, it.previousIndex());
			assertEquals(i, it.nextIndex());
			assertEquals(list.get(i), it.next());
		}

		for (int i = 0; i < list.size(); i++) {
			int index = list.size() - i - 1;
			assertEquals(index, it.previousIndex());
			assertEquals(index + 1, it.nextIndex());
			assertEquals(list.get(index), it.previous());
		}

	}

	@Test(expected=IllegalStateException.class)
	public void testSetException() {
		String [][] data = {
				{"a", "b", "c", "d"}, 
				{"e", "f", "g", "h"},
				{"i", "j", "k", "l"},
				{"m", "n", "o", "p"}};
		List<String> list = new ArrayList<String>();
		for (String[] d : data)
			list.addAll(Arrays.asList(d));
		
		ArrayBunchList<String> abl = new ArrayBunchList<String>(data);
		ListIterator<String> it = abl.iterator();
		it.set("hoge");
	}

	@Test
	public void testSet() {
		String [][] data = {
				{"a", "b", "c", "d"}, 
				{"e", "f", "g", "h"},
				{"i", "j", "k", "l"},
				{"m", "n", "o", "p"}};
		List<String> list = new ArrayList<String>();
		for (String[] d : data)
			list.addAll(Arrays.asList(d));
		
		ArrayBunchList<String> abl = new ArrayBunchList<String>(data);
		ListIterator<String> it = abl.iterator();

		for (int i = 0; i < list.size(); i++) {
			String str = it.next();
			it.set(str + str);
		}

		for (int i = 0; i < list.size(); i++) {
			int index = list.size() - i - 1;
			assertEquals(list.get(index) + list.get(index), it.previous());
		}
	}

}
