//class Film
public class Film extends Production
{
	private int boxOfficeGross;
	public Film()
	{
		super();
		boxOfficeGross =0;
	}
	public Film(String t, String d, String w, int g)
	{
		super(t,d,w);
		boxOfficeGross =g;
	}
	public int getBoxOfficeGross()
	{
		return boxOfficeGross;
	}
	public void setBoxOfficeGross(int g)
	{
		boxOfficeGross=g;
	}
	public void display()
	{
		System.out.println("Title: "+ super.getTitle());
		System.out.println("Director: " + super.getDirector());
		System.out.println("Screenwriter: " + super.getWriter());
		System.out.println("Total gross: " + boxOfficeGross + " million");
	}
}
//class Film ends