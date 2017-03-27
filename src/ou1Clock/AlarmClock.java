package ou1Clock;

import java.awt.*;

public class AlarmClock extends Clock {
	private boolean active = false;
	private String alarmString;
	private boolean isRinging = false;

	/** Se Clock:s konstruktor.
	 */
	public AlarmClock() throws Exception {
		super();
	}

	/** Se Clock:s konstruktor.
	 */
	public AlarmClock(int timeH, int timeM) throws Exception {
		super(timeH, timeM);
	}

	/** Sätter Alarmklockans utlösningstid till given tidpunkt.
	 * @param hour
	 * @param minute
	 */
	public void setAlarm(int hour, int minute) throws Exception{
		if(hour < 0 || hour >= 24 || minute < 0 || minute >= 60)
			throw new IllegalArgumentException("Ett alarm kan endast vara mellan och lika med timmarna 0-23 och minutrarna 0-59.");
		alarmString = ((hour>9 ? ""+hour : "0"+hour) + ":" + (minute>9 ? ""+minute : "0"+minute));
	}

	/**
	 * @return - En sträng som visar tidpunkten som alarmklockan är satt att utlösas vid.
	 */
	public String getAlarm(){
		return alarmString;
	}

	/** Ökar alarmklockans minut resp. timvisare.
	 *
	 */
	@Override
	public void timeTick(){
		super.timeTick();

		if(isTriggered()){
			isRinging = true;
			System.out.println("alarm");
		}
	}

	/** Returnerar alarmklockans alarms tillstånd.
	 * @return - Sant om alarmklockan ringer och falskt om det inte ringer.
	 */
	public boolean isTriggered(){
		return (active && getTime().equals(alarmString)) || isRinging;
	}
	
	/** Aktiverar alarmklockans alarm.
	 */
	public void turnOn(){
		active = true;
	}
	
	/** Avaktiverar alarmklockans alarm och stänger av alarmet.
	 */
	public void turnOff(){
		active = false;
		isRinging = false;
	}
}
