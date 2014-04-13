
public class Ask {
	public static boolean isWorkingDay(WeekDay day) throws Exception {
		switch (day) {
		case SUNDAY: case SATURDAY:
			return false;
		case MONDAY: case TUESDAY: case WEDNESDAY: case THURSDAY: case FRIDAY:
			return true;
		default:
			throw new Exception();
		}
		/*
		if (day == WeekDay.SUNDAY)
			return false;
		else if (day == WeekDay.MONDAY)
			return true;
		else if (day == WeekDay.TUESDAY)
			return true;
		else if (day == WeekDay.WEDNESDAY)
			return true;
		else if (day == WeekDay.THURSDAY)
			return true;
		else if (day == WeekDay.FRIDAY)
			return true;
		else if (day == WeekDay.SATURDAY)
			return false;
		else
			throw new Exception();
		*/
	}
}
