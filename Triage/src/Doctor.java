//Richard Sage
public class Doctor implements Comparable<Doctor>
{	
	private String name;
	private int timeAvailable;
	private int timePut;
	public Doctor()
	{
		name="";
		timeAvailable=0;
		timePut=0;
	}
	public Doctor(String n, int t)
	{
		name=n;
		timePut=t;
		timeAvailable=0;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public int gettimeAvailable() 
	{
		return timeAvailable;
	}
	public int gettimePut() 
	{
		return timePut;
	}
	public void setTime(int t, Patient p) 
	{
		timePut=t;
		timeAvailable=t+p.getTc().getNum();
	}
	public int compareTo(Doctor o)
	{
		if(timeAvailable==o.gettimeAvailable())
			return timePut-o.gettimePut();
		else return timeAvailable-o.gettimeAvailable();
	}
	public boolean equals(Doctor o)
	{
		return this.compareTo(o)==0;
	}
	public String toString()	
	{
		return "Name: "+name+", Time Available: "+timeAvailable+
			", Time Put In: "+timePut;
	}
}