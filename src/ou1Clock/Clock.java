package ou1Clock;

public class Clock {
	private NumberDisplay hours;
	private NumberDisplay minutes;
	private String displayString;
	int hrs = 24;
	int mins = 60;
	
	/**
	 * 
	 */
	public Clock(){
		try{
			hours = new NumberDisplay(0, hrs);
			minutes = new NumberDisplay(0, mins);
			
		}catch(Exception e){
			System.out.println(e);
		}
	}
	
	/**
	 * @param timeH
	 * @param timeM
	 */
	public Clock(int timeH, int timeM){
		try{
			hours = new NumberDisplay(0, hrs);
			minutes = new NumberDisplay(0, mins);
			setTime(timeH, timeM);
		}catch(Exception e){
			System.out.println(e);
		}
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
	public void setTime(int hour, int minute){
		hours.setValue(hour);
		minutes.setValue(minute);
	}
}
