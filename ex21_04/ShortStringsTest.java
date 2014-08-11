import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;


public class ShortStringsTest {

	@Test
	public void testNextPrevious1() {
		int maxLen = 4;
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("b");
		list.add("ccccc");
		list.add("dd");
		list.add("eeeee");
		list.add("fff");
		list.add("ggggg");
		list.add("hhhh");
		list.add("iiiii");
		
		ListIterator<String> it = list.listIterator();
		ShortStrings ss = new ShortStrings(it, maxLen);
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals("b", ss.next());
		assertEquals(0, ss.previousIndex());
		assertEquals(1, ss.nextIndex());
		assertEquals("dd", ss.next());
		assertEquals(1, ss.previousIndex());
		assertEquals(2, ss.nextIndex());
		assertEquals("fff", ss.next());
		assertEquals(2, ss.previousIndex());
		assertEquals(3, ss.nextIndex());
		assertEquals("hhhh", ss.next());
		assertEquals(3, ss.previousIndex());
		assertEquals(4, ss.nextIndex());
		assertEquals("hhhh", ss.previous());
		assertEquals(2, ss.previousIndex());
		assertEquals(3, ss.nextIndex());
		assertEquals("fff", ss.previous());
		assertEquals(1, ss.previousIndex());
		assertEquals(2, ss.nextIndex());
		assertEquals("dd", ss.previous());
		assertEquals(0, ss.previousIndex());
		assertEquals(1, ss.nextIndex());
		assertEquals("b", ss.previous());
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
	}

	@Test
	public void testNextPrevious2() {
		int maxLen = 5;
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("b");
		list.add("ccccc");
		list.add("dd");
		list.add("eeeee");
		list.add("fff");
		list.add("ggggg");
		list.add("hhhh");
		list.add("iiiii");
		
		ListIterator<String> it = list.listIterator();
		ShortStrings ss = new ShortStrings(it, maxLen);
		assertEquals("aaaaa", ss.next());
		assertEquals("b", ss.next());
		assertEquals("ccccc", ss.next());
		assertEquals("dd", ss.next());
		assertEquals("eeeee", ss.next());
		assertEquals("fff", ss.next());
		assertEquals("ggggg", ss.next());
		assertEquals("hhhh", ss.next());
		assertEquals("iiiii", ss.next());
		assertEquals("iiiii", ss.previous());
		assertEquals("hhhh", ss.previous());
		assertEquals("ggggg", ss.previous());
		assertEquals("fff", ss.previous());
		assertEquals("eeeee", ss.previous());
		assertEquals("dd", ss.previous());
		assertEquals("ccccc", ss.previous());
		assertEquals("b", ss.previous());
		assertEquals("aaaaa", ss.previous());
	}
	
	
	@Test(expected=IllegalStateException.class)
	public void testRemove() {
		int maxLen = 4;
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("b");
		list.add("ccccc");
		list.add("dd");
		list.add("eeeee");
		list.add("fff");
		list.add("ggggg");
		list.add("hhhh");
		list.add("iiiii");
		
		ListIterator<String> it = list.listIterator();
		ShortStrings ss = new ShortStrings(it, maxLen);
		ss.remove();
	}
	
	@Test(expected=IllegalStateException.class)
	public void testRemoveTwice() {
		int maxLen = 4;
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("b");
		list.add("ccccc");
		list.add("dd");
		list.add("eeeee");
		list.add("fff");
		list.add("ggggg");
		list.add("hhhh");
		list.add("iiiii");
		
		ListIterator<String> it = list.listIterator();
		ShortStrings ss = new ShortStrings(it, maxLen);
		ss.next();
		ss.remove();
		ss.remove();
	}
		
	@Test
	public void testRemoveAll() {
		int maxLen = 4;
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("b");
		list.add("ccccc");
		list.add("dd");
		list.add("eeeee");
		list.add("fff");
		list.add("ggggg");
		list.add("hhhh");
		list.add("iiiii");
		
		ListIterator<String> it = list.listIterator();
		ShortStrings ss = new ShortStrings(it, maxLen);
		assertEquals(true, ss.hasNext());
		assertEquals(false, ss.hasPrevious());
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals("b", ss.next());
		ss.remove();
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals("dd", ss.next());
		ss.remove();
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals("fff", ss.next());
		ss.remove();
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals("hhhh", ss.next());
		ss.remove();
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals(false, ss.hasNext());
		assertEquals(false, ss.hasPrevious());
	}
	
	@Test
	public void testRemoveAll2() {
		int maxLen = 4;
		List<String> list = new ArrayList<String>();
		list.add("aaaaa");
		list.add("b");
		list.add("ccccc");
		list.add("dd");
		list.add("eeeee");
		list.add("fff");
		list.add("ggggg");
		list.add("hhhh");
		list.add("iiiii");
		
		ListIterator<String> it = list.listIterator();
		ShortStrings ss = new ShortStrings(it, maxLen);
		assertEquals("b", ss.next());
		assertEquals("dd", ss.next());
		assertEquals("fff", ss.next());
		assertEquals("hhhh", ss.next());
		assertEquals(3, ss.previousIndex());
		assertEquals(4, ss.nextIndex());
		assertEquals(false, ss.hasNext());
		assertEquals(true, ss.hasPrevious());
		ss.remove();
		assertEquals(2, ss.previousIndex());
		assertEquals(3, ss.nextIndex());
		assertEquals(false, ss.hasNext());
		assertEquals(true, ss.hasPrevious());
		assertEquals("fff", ss.previous());
		ss.remove();
		assertEquals(1, ss.previousIndex());
		assertEquals(2, ss.nextIndex());
		assertEquals(false, ss.hasNext());
		assertEquals(true, ss.hasPrevious());
		assertEquals("dd", ss.previous());
		ss.remove();
		assertEquals(0, ss.previousIndex());
		assertEquals(1, ss.nextIndex());
		assertEquals(false, ss.hasNext());
		assertEquals(true, ss.hasPrevious());
		assertEquals("b", ss.previous());
		ss.remove();
		assertEquals(-1, ss.previousIndex());
		assertEquals(0, ss.nextIndex());
		assertEquals(false, ss.hasNext());
		assertEquals(false, ss.hasPrevious());
	}
}
