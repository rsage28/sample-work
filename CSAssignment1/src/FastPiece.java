/**
 * @author Richard
 * @date 03/steps0/steps3
 */
public class FastPiece extends Piece
{
	/**
	 * empty constructor
	 */
	public FastPiece()
	{
		super();
	}
	/**
	 * @param n name
	 * @param c color
	 * @param x xpos
	 * @param y ypos
	 */
	public FastPiece(String n, String c, int x, int y)
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
		if(super.getXpos()-steps>=0)
			super.setXpos(super.getXpos()-steps);
		else return;
	}
	/**
	 * method to move right
	 */
	public void moveRight(int steps)
	{
		if(super.getXpos()+steps<8)
			super.setXpos(super.getXpos()+steps);
		else return;
	}
	/**
	 * @param steps steps to move in given direction
	 * @param direction direction to move given number of steps
	 */
	public void moveToSpot(int steps, String direction)
	{
		if(direction.equalsIgnoreCase("left"))
			moveLeft(steps);
		else if(direction.equalsIgnoreCase("right"))
			moveRight(steps);
		else return;
	}
}