//class Play
public class Play extends Production
{
	private int performances;
	public Play()
	{
		super();
		performances =0;
	}
	public Play(String t, String d, String w, int p)
	{
		super(t,d,w);
		performances = p;
	}
	public int getPerformances()
	{
		return performances;
	}
	public void setPerformances(int p)
	{
		performances = p;
	}
	public void display()
	{
		System.out.println("Title: "+ super.getTitle());
		System.out.println("Director: " + super.getDirector());
		System.out.println("Playwright: " + super.getWriter());
		System.out.println("Performances: " + performances);
	}
}
//class Play ends