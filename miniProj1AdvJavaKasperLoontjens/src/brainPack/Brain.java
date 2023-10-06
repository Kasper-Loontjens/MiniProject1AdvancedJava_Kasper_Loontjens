package brainPack;

import clockPack.DateClass;
import clockPack.TimeClass;
import guiPack.GUI;

public abstract class Brain {
	
	//Brain controls display
	
	// Creates enum for the clocks different states, changing these will change the UI
	public enum DisplayState{
		DISPLAYTIME,
		CHANGETIME,
		DISPLAYDATE,
		CHANGEDATE
	}
	DisplayState displayState = DisplayState.DISPLAYTIME;
	 
	// updates the GUI
	protected abstract void updateGUI();

	// Creates necessary dates and times to be shown in clock
	protected DateClass dateClass = new DateClass(2023, 10, 06);
	protected TimeClass timeClass = new TimeClass(12,06,35);
	
	
	// When a "set" button is clicked from GUI this method will change display
	public void setClicked() {
		switch (displayState) {
		case DISPLAYTIME:
			displayState = DisplayState.CHANGETIME;
			updateGUI();
			break;
		case CHANGETIME:
			displayState = DisplayState.DISPLAYTIME;
			updateGUI();
			break;
		case DISPLAYDATE:
			displayState = DisplayState.CHANGEDATE;
			updateGUI();
			break;
		case CHANGEDATE:
			displayState = DisplayState.DISPLAYDATE;
			updateGUI();
			break;
		default:
		}
	}
	
	// When a "switch" button is clicked from GUI this method will change display
	public void switchClicked() {
		switch (displayState) {
		case DISPLAYDATE:
			displayState = DisplayState.DISPLAYTIME;
			updateGUI();
			break;
		case DISPLAYTIME:
			displayState = DisplayState.DISPLAYDATE;
			updateGUI();
			break;
		default:
		}
	}
	
	public DisplayState getDisplayState() {
		return displayState;
	}

	public void setDisplayState(DisplayState displayState) {
		this.displayState = displayState;
	}


	
	
}
