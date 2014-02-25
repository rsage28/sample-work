/**
 * @author Richard
 * @date 03/10/13
 */
public class SlowPiece extends Piece
{
	/**
	 * empty constructor
	 */
	public SlowPiece()
	{
		super();
	}
	/**
	 * @param n name
	 * @param c color
	 * @param x xpos
	 * @param y ypos
	 */
	public SlowPiece(String n, String c, int x, int y)
	{
		super(n,c,x,y);
	}
	/**
	 * method to move left or right
	 */
	public void leftOrRight(String direction) 
	{
		if(direction.equalsIgnoreCase("left"))
		{
			if(super.getXpos()+1<8)
				moveLeft(1);
			else return;
		}
		else if(direction.equalsIgnoreCase("right"))
		{
			if(super.getXpos()-1>=0)
				moveRight(1);
			else return;
		}
	}
	/**
	 * method to move left
	 */
	public void moveLeft(int steps)
	{
		if(super.getXpos()-1>=0)
			super.setXpos(super.getXpos()-1);
		else return;
	}
	/**
	 * method to move right
	 */
	public void moveRight(int steps) 
	{
		if(super.getXpos()+1<8)
			super.setXpos(super.getXpos()+1);
		else return;
	}
	/**
	 * @return returns string of all the attributes
	 */
	public String toString()
	{
		return super.toString();
	}
}