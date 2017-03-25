package ou1ClockTest;

import org.junit.jupiter.api.Test;
import ou1Clock.Clock;

import static org.junit.jupiter.api.Assertions.fail;

public class ClockTest {

	@Test
	public void ClockTest() {
		Clock clock = new Clock();
	}
	
	@Test
	public void ClockParamTest() {
		Clock clock = new Clock(12, 00);
	}
	
	@Test
	public void getTimeTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void setTimeTest() {
		fail("Not yet implemented");
	}
	
	@Test
	public void timeTickTest() {
		fail("Not yet implemented");
	}
}
