package ou1Clock;

public class NumberDisplay {
	protected int minLimit, maxLimit, value;

	/**  Skapar en ny numberdisplay med värdet minLimit och
	 *  gränserna minLimit och maxLimit. Om maxLimit inte
	 *  är större än minLimit ska ett undantag genereras.
	 *  @return
	 */
	// KASTA EXCEPTION
	public NumberDisplay(int minLimit, int maxLimit) throws IllegalArgumentException{
		if(maxLimit <= minLimit){
			throw new IllegalArgumentException("maxLimit måste överstiga minLimit. Givna min = " + minLimit
												+ ". Givna max = " + maxLimit+".");
		}else{			
			value = minLimit;
			this.minLimit = minLimit;
			this.maxLimit = maxLimit;
		}
	}
	
	
	/** Returnerar det aktuella värdet på displayen som ett
	 *  heltal.
	 *  @return
	 */
	public int getValue(){
		return value;
	}
	
	/** Sätter värdet på displayen till newValue. Om newValue
	 * är mindre än minLimit eller större än maxgränsen så
	 * genereras ett undantag.
	 * @return
	 */
	public void setValue(int newValue) throws Exception{
		if(newValue < minLimit || newValue >= maxLimit)
			throw new IllegalArgumentException("newValue får ej överskrida maxLimit, och måste vara större än minLimit." +
											" Givna newValue: " + newValue);
		value = newValue;
	}
	
	/** Returnerar det aktuella värdet på displayen som en sträng. 
	 * Värden som består av färre siffror inleds med ett antal 
	 * 0:or så att de blir lika långa.
	 * @return
	 */
	public String getDisplayValue(){
		return (value > 9 ? ("" + value) : ("0" + value));
	}
	
	/** Ökar displayens värde med 1 och ser till att värdet blir 
	 * minLimit om maxLimit är nådd.
	 *  @return
	 */
	public void increment(){
		value = value < maxLimit-1 ? value+1 : minLimit;
	}
	
	/** Returnerar true om det senaste anropet till increment ledde 
	 * till att man startade om från minLimit annars false.
	 * @return 
	 */
	public boolean didWrapAround(){
		return value == minLimit;
	}
}
