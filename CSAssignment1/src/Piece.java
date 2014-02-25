/**
 * @author Richard
 * @date 03/10/13
 */
public abstract class Piece
{
	/**
	 * attributes
	 */
	private String name;
	private String color;
	private int xpos;
	private int ypos;
	/**
	 * empty constructor
	 */
	public Piece()
	{
		name = "";
		color = "";
		xpos = 0;
		ypos = 0;
	}
	/**
	 * @param n name
	 * @param c color
	 * @param x xpos
	 * @param y ypos
	 */
	public Piece(String n, String c, int x, int y)
	{
		name = n;
		color = c;
		xpos = x;
		ypos = y;
	}
	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name set the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color set the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return xpos
	 */
	public int getXpos() {
		return xpos;
	}
	/**
	 * @param xpos set the new xpos
	 */
	public void setXpos(int xpos) {
		this.xpos = xpos;
	}
	/**
	 * @return ypos
	 */
	public int getYpos() {
		return ypos;
	}
	/**
	 * @param ypos set the new ypos
	 */
	public void setYpos(int ypos) {
		this.ypos = ypos;
	}
	/**
	 * method to be implemented by children classes to move left or right on the board
	 */
	public abstract void leftOrRight(String direction);
	/**
	 * method to be implemented by children classes to move left
	 */
	public abstract void moveLeft(int steps);
	/**
	 * method to be implemented by children classes to move right
	 */
	public abstract void moveRight(int steps);
	/**
	 * @return string of all the attributes
	 */
	public String toString()
	{
		return "Name: "+name+", Color: "+color+", Xpos: "+xpos+", Ypos: "+ypos;
	}
	public boolean equals(Object o)
	{
		return (((Piece)(Object)o).getXpos()==xpos&&((Piece)(Object)o).getYpos()==ypos);
	}
}