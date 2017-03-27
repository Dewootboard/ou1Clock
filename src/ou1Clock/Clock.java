package ou1Clock;

public class Clock {
	private NumberDisplay hours;
	private NumberDisplay minutes;
	private String displayString;
	
	/**
	 * 
	 */
	public Clock() throws Exception {
		hours = new NumberDisplay(0, 24);
		minutes = new NumberDisplay(0, 60);
		updateDisplay();
	}
	
	/**
	 * @param timeH
	 * @param timeM
	 */
	public Clock(int timeH, int timeM) throws Exception {
		hours = new NumberDisplay(0, 24);
		minutes = new NumberDisplay(0, 60);
		setTime(timeH, timeM);
		updateDisplay();
	}
	
	/**
	 * 
	 */
	public void timeTick(){
		minutes.increment();
		if(minutes.didWrapAround()){
			hours.increment();
		}
	}
	
	/**
	 * @return
	 */
	public String getTime(){
		updateDisplay();
		return displayString;
	}
	
	/**
	 * 
	 */
	private void updateDisplay(){
		displayString = (hours.getDisplayValue() + ":" + minutes.getDisplayValue());
	}
	
	/**
	 * @param hour
	 * @param minute
	 */
	public void setTime(int hour, int minute) throws Exception {
		hours.setValue(hour);
		minutes.setValue(minute);
	}
}
