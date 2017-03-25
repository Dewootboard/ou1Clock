package ou1Clock;

import java.awt.*;

public class AlarmClock extends Clock{
	private boolean active = false;
	private String alarmString;
	private boolean isRinging = false;
	
	/**
	 * @param hour
	 * @param minute
	 */
	public void setAlarm(int hour, int minute){
		alarmString = (+ hour>9 ? (""+hour) : ("0"+hour) + ":" + minute);
	}
	
	/* (non-Javadoc)
	 * @see ou1Clock.Clock#timeTick()
	 */
	@Override
	public void timeTick(){
		super.timeTick();
		
		if(isTriggered()){
			isRinging = true;
			System.out.println("ALARM!");
		}
	}
	
	/**
	 * @return
	 */
	public boolean isTriggered(){
		return active && getTime().equals(alarmString) || isRinging;
	}
	
	/**
	 * 
	 */
	public void turnOn(){
		active = true;
	}
	
	/**
	 * 
	 */
	public void turnOff(){
		active = false;
		isRinging = false;
	}
}
