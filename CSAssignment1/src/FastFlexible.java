/**
 * @author Richard
 * @date 03/steps0/steps3
 */
public class FastFlexible extends FastPiece
{
	/**
	 * empty constructor
	 */
	public FastFlexible()
	{
		super();
	}
	/**
	 * @param n name
	 * @param c color
	 * @param x xpos
	 * @param y ypos
	 */
	public FastFlexible(String n, String c, int x, int y)
	{
		super(n,c,x,y);
	}
	/**
	 * method to move up
	 */
	public void moveDown(int steps)
	{
		if(super.getYpos()+steps<8)
			super.setYpos(super.getYpos()+steps);
		else return;
	}
	/**
	 * method to move down
	 */
	public void moveUp(int steps)
	{
		if(super.getYpos()-steps>=0)
			super.setYpos(super.getYpos()-steps);
		else return;
	}
	/**
	 * method to move up or down
	 */
	public void moveUpOrDown(int steps, String direction)
	{
		System.out.println("A");
		if(direction.equalsIgnoreCase("up"))
		{
			if(super.getYpos()-steps<8)
				moveUp(steps);
			else return;
		}
		else if(direction.equalsIgnoreCase("down"))
		{
			if(super.getYpos()+steps>=0)
				moveDown(steps);
			else return;
		}
	}
}