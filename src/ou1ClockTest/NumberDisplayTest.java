package ou1ClockTest;

import org.junit.jupiter.api.Test;
import ou1Clock.NumberDisplay;

import static org.junit.jupiter.api.Assertions.fail;

public class NumberDisplayTest {
	@Test
	public void NumberDisplayTest() {
		NumberDisplay numD;
		for(int i = 0; i < 24; i++){
			for(int j = 0; j < 60; j++){
				try{
					numD = new NumberDisplay(i, j);
				}catch(IllegalArgumentException e){
					if(j > i) {
						fail("Kastar undantag vid korrekt angivna parametrar: " + e.toString());
					}
				}
			}
		}
	}

	@Test
	public void getValueTest() {
		NumberDisplay numD;

		for(int i = 0; i < 10; i++){
			numD = new NumberDisplay(i,10);
			if(numD.getValue() != i){
				fail("Förväntat värde skiljer sig från det returnerade värdet.");
			}
		}

	}

	@Test
	public void setValueTest() throws Exception{
		NumberDisplay numD = new NumberDisplay(0,10);

		for(int i = 0; i < 10; i++){
			numD.setValue(i);
			if(numD.getValue() != i){
				fail("Förväntat värde skiljer sig från det returnerade värdet.");
			}
		}
	}

	@Test
	public void incrementTest() {
		NumberDisplay numD = new NumberDisplay(0,10);
		int last;
		for(int i = 0; i < 9; i++){
			last = numD.getValue();
			numD.increment();
			if(last != numD.getValue()-1){
				fail("Förväntat värde skiljer sig från det returnerade värdet.");
			}
		}
	}

	@Test
	public void getDisplayValueTest() {
		NumberDisplay numD = new NumberDisplay(0,11);

		for(int i = 0; i < 11; i++){
			if(i < 10){
				if(!numD.getDisplayValue().equals(("0" + i))){
					fail("Förväntad sträng skiljer sig från den returnerade strängen.");
				}
			}else{
				if(!numD.getDisplayValue().equals("" + i)){
					fail("Förväntad sträng skiljer sig från den returnerade strängen.");
				}
			}
			numD.increment();
		}
	}

	@Test
	public void didWrapAroundTest() {
		NumberDisplay numD = new NumberDisplay(0,10);

		for(int i = 0; i < 10; i++){
			numD.increment();
		}
		if(numD.getValue() != 0){
			fail("Förväntat värde skiljer sig från det returnerade värdet.");
		}

	}
}
