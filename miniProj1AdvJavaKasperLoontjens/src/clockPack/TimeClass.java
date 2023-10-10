package clockPack;

public class TimeClass extends ClockAbstract {
	private int hour;
	private int minute;
	private int second;
	
	public TimeClass(int hour, int minute, int second) {
		// TODO Auto-generated constructor stub
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	// Checks if integers are within scope, if they are, the integers are set as time.
	@Override
	public boolean validateInput(int hour, int minute, int second) {
		// TODO Auto-generated method stub
		if (hour < 24 && hour >= 0 &&
				minute < 60 && minute >= 0 &&
				second < 60 && second >= 0) {
			
			setHour(hour);
			setMinute(minute);
			setSecond(second);
			return true;
		}
		return false;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
