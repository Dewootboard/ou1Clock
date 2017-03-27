package ou1Clock;

public class NumberDisplay {
	protected int minLimit, maxLimit, value;

	/**  Skapar en ny numberdisplay med v�rdet minLimit och
	 *  gr�nserna minLimit och maxLimit. Om maxLimit inte
	 *  �r st�rre �n minLimit ska ett undantag genereras.
	 *  @return
	 */
	// KASTA EXCEPTION
	public NumberDisplay(int minLimit, int maxLimit) throws IllegalArgumentException{
		if(maxLimit <= minLimit){
			throw new IllegalArgumentException("maxLimit m�ste �verstiga minLimit. Givna min = " + minLimit
												+ ". Givna max = " + maxLimit+".");
		}else{			
			value = minLimit;
			this.minLimit = minLimit;
			this.maxLimit = maxLimit;
		}
	}
	
	
	/** Returnerar det aktuella v�rdet p� displayen som ett
	 *  heltal.
	 *  @return
	 */
	public int getValue(){
		return value;
	}
	
	/** S�tter v�rdet p� displayen till newValue. Om newValue
	 * �r mindre �n minLimit eller st�rre �n maxgr�nsen s�
	 * genereras ett undantag.
	 * @return
	 */
	public void setValue(int newValue) throws Exception{
		if(newValue < minLimit || newValue >= maxLimit)
			throw new IllegalArgumentException("newValue f�r ej �verskrida maxLimit, och m�ste vara st�rre �n minLimit." +
											" Givna newValue: " + newValue);
		value = newValue;
	}
	
	/** Returnerar det aktuella v�rdet p� displayen som en str�ng. 
	 * V�rden som best�r av f�rre siffror inleds med ett antal 
	 * 0:or s� att de blir lika l�nga.
	 * @return
	 */
	public String getDisplayValue(){
		return (value > 9 ? ("" + value) : ("0" + value));
	}
	
	/** �kar displayens v�rde med 1 och ser till att v�rdet blir 
	 * minLimit om maxLimit �r n�dd.
	 *  @return
	 */
	public void increment(){
		value = value < maxLimit-1 ? value+1 : minLimit;
	}
	
	/** Returnerar true om det senaste anropet till increment ledde 
	 * till att man startade om fr�n minLimit annars false.
	 * @return 
	 */
	public boolean didWrapAround(){
		return value == minLimit;
	}
}
