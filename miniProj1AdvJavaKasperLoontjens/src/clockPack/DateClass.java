package clockPack;

public class DateClass extends ClockAbstract  {
	
	private int year;
	private int month;
	private int day;
	


	public DateClass(int year, int month, int day) {
		// TODO Auto-generated constructor stub
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	// Checks if integers are within scope, if they are, the integers are set as dates.
	@Override
	public boolean validateInput(int year, int month, int day) {
		// TODO Auto-generated method stub
		if (year <= 9999 && year >= 0 &&
				month <= 12 && month > 0 &&
				day <= 31 && day > 0) {

			setYear(year);
			setMonth(month);
			setDay(day);
			return true;
		}
		return false;
	}

}
