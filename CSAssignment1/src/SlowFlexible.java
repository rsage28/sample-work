/**
 * @author Richard
 * @date 03/10/13
 */
public class SlowFlexible extends SlowPiece
{
	/**
	 * empty constructor
	 */
	public SlowFlexible()
	{
		super();
	}
	/**
	 * @param n name
	 * @param c color
	 * @param x xpos
	 * @param y ypos
	 */
	public SlowFlexible(String n, String c, int x, int y)
	{
		super(n,c,x,y);
	}
	/**
	 * method to move up
	 */
	public void moveDown()
	{
		if(super.getYpos()+1<8)
			super.setYpos(super.getYpos()+1);
		else return;
	}
	/**
	 * method to move down
	 */
	public void moveUp()
	{
		if(super.getYpos()-1>=0)
			super.setYpos(super.getYpos()-1);
		else return;
	}
	/**
	 * method to move up or down
	 */
	public void moveUpOrDown(String direction)
	{
		if(direction.equalsIgnoreCase("up"))
		{
			if(super.getYpos()-1<8)
				moveUp();
			else return;
		}
		else if(direction.equalsIgnoreCase("down"))
		{
			if(super.getYpos()+1>=0)
				moveDown();
			else return;
		}
	}
}