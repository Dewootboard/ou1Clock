package ou1ClockTest;

import org.junit.*;
import ou1Clock.AlarmClock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.CoreMatchers.*;

public class AlarmClockTest {

	@Test
	public void AlarmClock() throws Exception{
		new AlarmClock();
	}


	@Test
	public void AlarmClockParam() throws Exception{
		for (int i = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				new AlarmClock(i,j);
			}
		}
	}


    @Test
    public void isTriggered() throws Exception {
        AlarmClock aClock = new AlarmClock(0,0);
        aClock.setAlarm(0,0);

        if(aClock.isTriggered()){
			fail("Alarm som inte är aktiverat ska inte kunna vara triggered.");
		}

		aClock.turnOn();
		if(!aClock.isTriggered()){
			fail("Alarm  är aktiverat ska vara triggered.");
		}

		aClock.turnOff();
		if(aClock.isTriggered()){
			fail("Alarm som inte är aktiverat ska inte kunna vara triggered.");
		}
    }

	@Test
	public void setAlarmTest() throws Exception {
		AlarmClock aClock;

		for(int i = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				aClock = new AlarmClock(i, j);
				aClock.setAlarm(i,j);
				assertThat(aClock.getAlarm(),is(not(aClock.getTime())));
			}
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void setAlarmFailTest1() throws Exception {
		AlarmClock aClock = new AlarmClock(0,0);
		aClock.setAlarm(-1,0);
	}

	@Test (expected = IllegalArgumentException.class)
	public void setAlarmFailTest2() throws Exception {
		AlarmClock aClock = new AlarmClock(0,0);
		aClock.setAlarm(-1,-1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void setAlarmFailTest3() throws Exception {
		AlarmClock aClock = new AlarmClock(0,0);
		aClock.setAlarm(0,-1);
	}

	@Test
	public void turnOnTest() throws Exception {
		PrintStream out = System.out;
		try{
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			System.setOut(new PrintStream(output));

			AlarmClock aClock = new AlarmClock(0,0);
			aClock.setAlarm(0,0);
			aClock.turnOn();
			if(!output.toString().equals("alarm\n")){
				fail("Alarmklockan skriver ej ut 'alarm' när den förväntas göra det.");
			}
		}catch(Exception e){
		}finally{
			System.setOut(out);
		}
	}

	@Test
	public void turnOffTest() throws Exception {
		PrintStream out = System.out;
		try{
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			System.setOut(new PrintStream(output));

			AlarmClock aClock = new AlarmClock(0,0);
			aClock.setAlarm(0,0);
			aClock.turnOn();
			aClock.turnOff();
			assertEquals(output.toString(),"alarm\n");

		}catch(Exception e){
		}finally{
			System.setOut(out);
		}
	}

	@Test
	public void timeTickTest() {
		PrintStream out = System.out;
		try{
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			System.setOut(new PrintStream(output));

			AlarmClock aClock = new AlarmClock(0, 0);
			aClock.setAlarm(0, 0);
			aClock.turnOn();
			for(int i = 0; i < 24; i++){
				for(int j = 0; j < 60; j++){
					if(!output.toString().equals("alarm\n")){
						fail("Alarmklockan skriver ej ut 'alarm' när den förväntas göra det.");
					}
				}
			}

			aClock.turnOff();
			for(int i = 0; i < 24; i++){
				for(int j = 0; j < 60; j++){
					if(output.toString().equals("alarm\n")){
						fail("Alarmklockan skriver ut 'alarm' när den ej förväntas göra det.");
					}
				}
			}

		}catch(Exception e){
		}finally{
			System.setOut(out);
		}

	}
}
