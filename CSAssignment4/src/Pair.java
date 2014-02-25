/**
 * @author Richard
 * @date 19/11/13
 */
public class Pair
{
	/**
	 * attributes
	 */
	private char value;
	private int freq;
	/**
	 * @param v value
	 * @param f frequency
	 */
	public Pair(char v, int f)
	{
		value = v;
		freq = f;
	}
	/**
	 * getters and setters
	 */	
	public char getValue() {
		return value;
	}

	public void setValue(char value) {
		this.value = value;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
	/**
	 * @return string representation of Pair
	 */
	public String toString()
	{
		return "Value: "+value+" Frequency: "+freq;
	}
	/**
	 * @param p Pair being compared
	 * @return p minus this value
	 */
	public int compareTo(Pair p)
	{
		return p.getFreq()-freq;
	}
	public boolean equals(Pair p)
	{
		return (p.getFreq()==freq&&p.getValue()==value);
	}
}