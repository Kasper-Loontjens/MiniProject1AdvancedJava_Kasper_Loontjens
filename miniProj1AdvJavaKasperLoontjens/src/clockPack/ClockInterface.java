package clockPack;

public interface ClockInterface {
	
	
	// Prepares to set dates and times
	abstract boolean readyToSet( String str, String str2, String str3 );
	
	
	// Checks if integers are within scope, if they are, the integers are set as dates or time.
	abstract boolean validateInput(int firstInt, int secondInt, int thirdInt);
	
	
	//Makes sure string can be integer
	abstract boolean isInteger(String s);
}
