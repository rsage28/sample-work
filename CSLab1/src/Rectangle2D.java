//class name
public class Rectangle2D
{
	//attributes
	private double xpos;
	private double ypos;
	private double width;
	private double height;
	//constructors
	public Rectangle2D()
	{
		xpos=0;
		ypos=0;
		width=0;
		height=0;
	}
	public Rectangle2D(double x, double y, double w, double h)
	{
		xpos=x;
		ypos=y;
		width=w;
		height=h;
	}
	//getters and setters
	public double getXpos() {
		return xpos;
	}
	public void setXpos(double xpos) {
		this.xpos = xpos;
	}
	public double getYpos() {
		return ypos;
	}
	public void setYpos(double ypos) {
		this.ypos = ypos;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	//area method, returns double area
	public double getArea()
	{
		return width*height;
	}
	//perimeter method, returns double perimeter
	public double getPerimeter()
	{
		return (2*width)+(2*height);
	}
	//contains method, returns if point is in rectangle
	public boolean contains(double x, double y)
	{
		return (x<xpos+width&&x>xpos&&y<ypos+height&&y>ypos);
	}
	//contains method, returns if rectangle is in rectangle
	public boolean contains(Rectangle2D r)
	{
		return (r.getXpos()+r.getWidth()<xpos+width&&r.getXpos()>xpos&&r.getYpos()+r.getHeight()<ypos+height&&r.getXpos()>ypos);
	}
	//overlaps method, returns if rectangle overlaps rectangle
	public boolean overlaps(Rectangle2D r)
	{
		return (r.getXpos()>xpos&&r.getXpos()<xpos+width&&r.getYpos()>ypos&&r.getYpos()<ypos+height);
	}
}