package ou1ClockTest;

import org.junit.*;
import ou1Clock.Clock;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class ClockTest {

	@Test
	public void ClockTest() throws Exception{
		new Clock();
	}
	
	@Test
	public void ClockParamTest() throws Exception {
		for (int i = 0; i < 24; i++) {
			for (int j = 0; j < 60; j++) {
				new Clock(i, j);
			}
		}
	}

	@Test (expected = IllegalArgumentException.class)
	public void ClockWrongArgTest1() throws Exception {
		new Clock(-1, 1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void ClockWrongArgTest2() throws Exception {
		new Clock(1, -1);
	}

	@Test (expected = IllegalArgumentException.class)
	public void ClockWrongArgTest3() throws Exception {
		new Clock(-1, -1);
	}
	
	@Test
	public void getTimeTest() throws Exception{
		for(int i = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				if(!new Clock(i, j).getTime().equals((i > 9 ? i : "0" + i) + ":" + (j > 9 ? j : "0"+j))){
					fail("Klockans tid, returnerad i form av sträng, överensstämde ej med förväntad tid.");
				}
			}
		}
	}
	
	@Test
	public void setTimeTest() throws Exception{
		Clock clock = new Clock();

		for(int i  = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				clock.setTime(i,j);
				if(!clock.getTime().equals((i > 9 ? i : "0" + i) + ":" + (j > 9 ? j : "0"+j))){
					fail("Klockans tid, returnerad i form av sträng, överensstämde ej med förväntad tid.");
				}
			}
		}
    }
	
	@Test
	public void timeTickTest() throws Exception {
		Clock clock = new Clock();

		for(int i  = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				if(!clock.getTime().equals((i > 9 ? i : "0"+i) + ":" + (j>9 ? j : "0"+j))){
					fail("Klockans tid, returnerad i form av sträng, överensstämde ej med förväntad tid.");
				}
				clock.timeTick();
			}
		}
		clock.timeTick();
		if(clock.getTime().equals("00:00")){
			fail("Klockans tid, returnerad i form av sträng, överensstämde ej med förväntad tid.");
		}
	}
}
