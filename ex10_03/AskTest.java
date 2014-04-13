import static org.junit.Assert.*;

import org.junit.Test;


public class AskTest {

	@Test
	public void test() throws Exception {
		assertEquals(false, Ask.isWorkingDay(WeekDay.SUNDAY));
		assertEquals(true, Ask.isWorkingDay(WeekDay.MONDAY));
		assertEquals(true, Ask.isWorkingDay(WeekDay.TUESDAY));
		assertEquals(true, Ask.isWorkingDay(WeekDay.WEDNESDAY));
		assertEquals(true, Ask.isWorkingDay(WeekDay.THURSDAY));
		assertEquals(true, Ask.isWorkingDay(WeekDay.FRIDAY));
		assertEquals(false, Ask.isWorkingDay(WeekDay.SATURDAY));
	}

}
