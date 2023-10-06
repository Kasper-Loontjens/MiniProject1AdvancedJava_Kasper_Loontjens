package clockPack;

public interface ClockInterface {
	
	// Prepares to set dates and times
	public default boolean readyToSet( String str, String str2, String str3 ) {
		if (isInteger(str) && isInteger(str2) && isInteger(str3)) {
			if (qualifyInt(Integer.parseInt(str), Integer.parseInt(str2), Integer.parseInt(str3))) {
				return true;
			}
			return false;
		}else {
			return false;
		}
	};
	
	// Checks if integers are within scope, if they are, the integers are set as dates or time.
	abstract boolean qualifyInt(int firstInt, int secondInt, int thirdInt);
	
	
	//Makes sure string can be integer
	  public static boolean isInteger(String s) {
	        try {
	            Integer.parseInt(s);
	        } catch(NumberFormatException e) {
	            return false;
	        } catch(NullPointerException e) {
	            return false;
	        }
	        // only got here if we didn't return false
	        return true;
	    }

}
