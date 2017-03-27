package ou1ClockTest;

import org.junit.*;
import ou1Clock.AlarmClock;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.IllegalFormatCodePointException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

	@Test (expected = IllegalArgumentException.class)
	public void AlarmClockFaultyParam1() throws Exception{
		new AlarmClock(-1, 0);
	}


	@Test (expected = IllegalArgumentException.class)
	public void AlarmClockFaultyParam2() throws Exception{
		new AlarmClock(0, -1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void AlarmClockFaultyParam3() throws Exception{
		new AlarmClock(-1, -1);
	}

    @Test
    public void isTriggered() throws Exception {
        AlarmClock aClock = new AlarmClock(0,0);
        aClock.setAlarm(0,0);

		assertFalse(aClock.isTriggered());

		aClock.turnOn();
		assertFalse(!aClock.isTriggered());

		aClock.turnOff();
		assertFalse(aClock.isTriggered());
    }

	@Test
	public void setAlarmTest() throws Exception {
		AlarmClock aClock;

		for(int i = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				aClock = new AlarmClock(i, j);
				aClock.setAlarm(i,j);
				assertEquals(aClock.getAlarm(), aClock.getTime());
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
			assertThat(aClock.getAlarm(),is(not("alarm\n")));
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
			assertThat(aClock.getAlarm(),is(not("alarm\n")));
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
					aClock.timeTick();
					assertThat(aClock.getAlarm(),is(not("alarm\n")));
				}
			}

			aClock.turnOff();

			for(int i = 0; i < 24; i++){
				for(int j = 0; j < 60; j++){
					aClock.timeTick();
					assertEquals(output.toString(),"alarm" + System.lineSeparator());
				}
			}

		}catch(Exception e){
		}finally{
			System.setOut(out);
		}

	}
}
