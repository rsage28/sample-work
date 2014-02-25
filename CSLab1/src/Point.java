//class name
public class Point<T>
{
	//attributes
	private T xpos;
	private T ypos;
	//constructor
	public Point(T x, T y)
	{
		xpos=x;
		ypos=y;
	}
	//to string method
	public String toString()
	{
		return "X pos: "+xpos+"  Y pos: "+ypos;
	}
}