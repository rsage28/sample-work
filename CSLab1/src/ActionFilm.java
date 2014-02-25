//class name and extension
public class ActionFilm extends Film
{
	//attributes
	private String mainActor;
	private int yearReleased;
	//constructors
	public ActionFilm()
	{
		super();
		mainActor="";
		yearReleased=0;
	}
	public ActionFilm(String t, String d, String w, int g, String m, int y)
	{
		super(t,d,w,g);
		mainActor=m;
		yearReleased=y;
	}
	//getters and setters
	public String getMainActor() {
		return mainActor;
	}
	public void setMainActor(String mainActor) {
		this.mainActor = mainActor;
	}
	public int getYearReleased() {
		return yearReleased;
	}
	public void setYearReleased(int yearReleased) {
		this.yearReleased = yearReleased;
	}
	//display method overwrite
	public void display()
	{
		System.out.println("Title: "+ super.getTitle());
		System.out.println("Director: " + super.getDirector());
		System.out.println("Screenwriter: " + super.getWriter());
		System.out.println("Total gross: " + super.getBoxOfficeGross() + " million");
		System.out.println("Main Actor: "+getMainActor());
		System.out.println("Year Released: "+getYearReleased());
	}
}