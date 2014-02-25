public class TriageCode implements Comparable<TriageCode>
{
	private String code;
	private int num;
	
	public TriageCode()
	{
		code="";
		num=0;
	}
	public TriageCode(String c)
	{
		setAll(c);
	}	
	public String getCode() 
	{
		return code;
	}
	public int getNum() 
	{
		return num;
	}
	public void setAll(String color)
	{
		code=color;
		if(color.equalsIgnoreCase("red"))
			num=5;
		else if(color.equalsIgnoreCase("yellow"))
			num=3;
		else if(color.equalsIgnoreCase("green"))
			num=1;
		else if(color.equalsIgnoreCase("black"))
			num=0;
		else if(color.equalsIgnoreCase(""))
			num=0;
		else throw new IllegalArgumentException("not a valid code");
	}
	public int compareTo(TriageCode o) 
	{
		return o.getNum()-num;
	}
	public boolean equals(TriageCode o)
	{
		return this.compareTo(o)==0;
	}
	public String toString()	
	{
		return "Code: "+code+", Time: "+num;
	}
}
/*
tc1: Code: , Time: 0
tc2: Code: red, Time: 5
tc3: Code: yellow, Time: 3
tc4: Code: green, Time: 1
new tc1: Code: black, Time: 0
should be -2: -4
should be 1: 2
should be 0: 0
should be false: false
should be true: true
*/