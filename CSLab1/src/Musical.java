//class name
public class Musical extends Play
{
	//attributes
	private String composer;
	private String lyricist;
	//constructors
	public Musical()
	{
		super();
	}
	public Musical(String t, String d, String w, int p, String c, String l)
	{
		super(t,d,w,p);
		composer=c;
		lyricist=l;
	}
	//getters and setters
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public String getLyricist() {
		return lyricist;
	}
	public void setLyricist(String lyricist) {
		this.lyricist = lyricist;
	}
	//display method overwrite
	public void display()
	{
		System.out.println("Title: "+ super.getTitle());
		System.out.println("Director: " + super.getDirector());
		System.out.println("Playwright: " + super.getWriter());
		System.out.println("Performances: " + super.getPerformances());
		System.out.println("Composer: "+getComposer());
		System.out.println("Lyricist: "+getLyricist());
	}
}