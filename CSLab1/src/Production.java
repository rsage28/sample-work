//class Production
public class Production
{
	private String title;
	private String director;
	private String writer;
	public Production()
	{
		title="";
		director="";
		writer="";
	}
	public Production(String t, String d, String w)
	{
		title = t;
		director = d;
		writer = w;
	}
	public String getTitle()
	{
		return title;
	}
	public String getDirector()
	{
		return director;
	}
	public String getWriter()
	{
		return writer;
	}
	public void setTitle(String t)
	{
		title =t;
	}
	public void setDirector(String d)
	{
		director = d;
	}
	public void setWriter(String w)
	{
		writer = w;
	}
	public void display()
	{
		System.out.println("Production class");
	}
}
//class Production ends