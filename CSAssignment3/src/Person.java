/**
 * @author Richard
 * @date 4/11/13
 */
public class Person implements Comparable<Person>
{
	/**
	 * attribtes
	 */
	private String first;
	private String last;
	private int zip;
	/**
	 * empty constructor
	 */
	public Person()
	{
		first = "";
		last = "";
		zip = 0;
	}
	/**
	 * @param f first name
	 * @param l last name
	 * @param z zip
	 * parameter constructor
	 */
	public Person(String f, String l, int z)
	{
		first = f;
		last = l;
		zip = z;
	}
	/**
	 * @return the comparison between the two Person objects
	 */
	public int compareTo(Person o) 
	{
		return last.compareToIgnoreCase(o.getLast());
	}
	/**
	 * getters and setters 
	 */
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	/**
	 * @return the string representation of a Person object
	 */
	public String toString()
	{
		return "First: "+first+"\tLast: "+last+"\tZip: "+zip;
	}
}