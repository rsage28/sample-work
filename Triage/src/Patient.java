//Richard Sage
public class Patient implements Comparable<Patient>
{
	private String name;
	private TriageCode code;
	private int time;
	public Patient()
	{
		name="";
		code=new TriageCode("");
	}
	public Patient(String n, TriageCode tc, int t)
	{
		name=n;
		code=tc;
		time=t;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	public TriageCode getTc()
	{
		return code;
	}
	public void setCode(TriageCode t) 
	{
		code = t;
	}
	public void setTime(int t)
	{
		time=t;
	}
	public int getTime()
	{
		return time;
	}
	public int compareTo(Patient o) 
	{
		if(code.equals(o.getTc()))
			return o.getTime()-time;
		else return code.compareTo(o.getTc());
	}
	public boolean equals(Patient o)
	{
		return code.compareTo(o.getTc())==0;
	}
	public String toString()	
	{
		return "Name: "+name+", Code: "+code.getCode();
	}
}
/*
p1: Name: , Code: 
p2: Name: Hurless, Code: red
p3: Name: Steelman, Code: yellow
p4: Name: Sage, Code: green
new p1: Name: Miller, Code: black
should be 4: 4
should be 3: 3
should be 0: 0
should be false: false
should be true: true
*/