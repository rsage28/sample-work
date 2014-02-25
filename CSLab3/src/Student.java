/**
 * @author Richard
 * @date 01/10/13
 */
public class Student
{
	/**
	 * attributes
	 */
	private String id;
	private String name;
	/**
	 * empty constructor
	 */
	public Student()
	{
		id="";
		name="";
	}
	/**
	 * param constructor 
	 * @param i ID
	 * @param n Name
	 */
	public Student(String i, String n)
	{
		id=i;
		name=n;
	}
	/**
	 * @return id
	 */
	public String getID() {
		return id;
	}
	/**
	 * @param i ID to set
	 */
	public void setID(String i) {
		id = i;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name Name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return whether or not the object is equal
	 * @param o the object to be compared
	 */
	public boolean equals(Object o)
	{
		return ((((Student)o).getName()).equals(name)&&(((Student)o).getID()).equals(id));
	}
	/**
	 * @return the attributes of the object
	 */
	public String toString()
	{
		return "ID: "+id+", Name: "+name;
	}
}