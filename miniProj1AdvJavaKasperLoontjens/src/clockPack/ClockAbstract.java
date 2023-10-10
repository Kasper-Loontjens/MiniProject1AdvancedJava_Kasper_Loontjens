package clockPack;

public abstract class ClockAbstract implements ClockInterface {

	// Prepares to set dates and times
	public boolean readyToSet( String str, String str2, String str3 ) {
		if (isInteger(str) && isInteger(str2) && isInteger(str3)) {
			return validateInput(Integer.parseInt(str), Integer.parseInt(str2), Integer.parseInt(str3));
		} 
		return false;
	};

	
	//Makes sure string can be integer
	public boolean isInteger(String s) {
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
