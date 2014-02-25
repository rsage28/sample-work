import java.util.*;

/**
 * @author Richard
 * @date 03/10/13
 */
public class Board
{
	/**
	 * attributes
	 */
	private ArrayList<Piece> board;
	/**
	 * constructor
	 */
	public Board()
	{
		board = new ArrayList<Piece>();
	}
	/**
	 * @param name1 class name part 1
	 * @param name2 class name part 2
	 * @param xpos xpos for piece
	 * @param ypos ypos for piece
	 * @param name name for piece
	 * @param color color piece
	 */
	public void addNewPiece(String name1, String name2, int xpos, int ypos, String name, String color)
	{
		if(name1.equalsIgnoreCase("Slow")&&name2.equalsIgnoreCase("Piece")
				&&!board.contains(new SlowPiece(name, color, xpos, ypos)))
			board.add(new SlowPiece(name, color, xpos, ypos));
		else if(name1.equalsIgnoreCase("Slow")&&name2.equalsIgnoreCase("Flexible")
				&&!board.contains(new SlowFlexible(name, color, xpos, ypos)))
			board.add(new SlowFlexible(name, color, xpos, ypos));
		else if(name1.equalsIgnoreCase("Fast")&&name2.equalsIgnoreCase("Piece")
				&&!board.contains(new FastPiece(name, color, xpos, ypos)))
			board.add(new FastPiece(name, color, xpos, ypos));
		else if(name1.equalsIgnoreCase("Fast")&&name2.equalsIgnoreCase("Flexible")
				&&!board.contains(new FastFlexible(name, color, xpos, ypos)))
			board.add(new FastFlexible(name, color, xpos, ypos));
	}
	/**
	 * @param xpos xpos of piece
	 * @param ypos ypos of piece
	 * @param direction direction to move
	 * @param steps steps to move
	 */
	public void movePiece(int xpos, int ypos, String direction, int steps)
	{
		for(int i=0; i<board.size(); i++)
		{
			if(board.get(i).getXpos()==xpos&&board.get(i).getYpos()==ypos)
			{
				if(board.get(i) instanceof SlowFlexible)
				{
					{
						switch(direction)
						{
						case "left": if(!board.contains(new SlowFlexible(null, null, board.get(i).getXpos()-1, 
								board.get(i).getYpos())))
							board.get(i).moveLeft(steps); break;
						case "right": if(!board.contains(new SlowFlexible(null, null, board.get(i).getXpos()+1, 
								board.get(i).getYpos())))
							board.get(i).moveRight(steps); break;
						case "up": if(!board.contains(new SlowFlexible(null, null, board.get(i).getXpos(), 
								board.get(i).getYpos()-1))) 
							((SlowFlexible) board.get(i)).moveUpOrDown("up"); break;
						case "down": if(!board.contains(new SlowFlexible(null, null, board.get(i).getXpos()-1, 
								board.get(i).getYpos()+1)))
							((SlowFlexible) board.get(i)).moveUpOrDown("down"); break;
						}
					}
				}
				else if(board.get(i) instanceof FastFlexible)
				{
					{
						switch(direction)
						{
						case "left": if(!board.contains(new FastFlexible(null, null, board.get(i).getXpos()-steps, 
								board.get(i).getYpos())))
							board.get(i).moveLeft(steps); break;
						case "right": if(!board.contains(new FastFlexible(null, null, board.get(i).getXpos()+steps, 
								board.get(i).getYpos())))
							board.get(i).moveRight(steps); break;
						case "up": if(!board.contains(new FastFlexible(null, null, board.get(i).getXpos(), 
								board.get(i).getYpos()-steps))) 
							((FastFlexible) board.get(i)).moveUpOrDown(steps, "up"); break;
						case "down": if(!board.contains(new FastFlexible(null, null, board.get(i).getXpos(), 
								board.get(i).getYpos()+steps)))
							((FastFlexible) board.get(i)).moveUpOrDown(steps, "down"); break;
						}
					}
				}
				else if(board.get(i) instanceof SlowPiece)
				{
					if(direction.equalsIgnoreCase("left")&&!board.contains(new SlowPiece
							(null, null, board.get(i).getXpos()-1, board.get(i).getYpos())))
					{
						board.get(i).moveLeft(steps);
					}
					else if(direction.equalsIgnoreCase("right")&&!board.contains(new SlowPiece
							(null, null, board.get(i).getXpos()+1, board.get(i).getYpos())))
						board.get(i).moveRight(steps);
				}
				else if(board.get(i) instanceof FastPiece)
				{
					if(direction.equalsIgnoreCase("left")&&!board.contains(new FastPiece
							(null, null, board.get(i).getXpos()-1, board.get(i).getYpos())))
						board.get(i).moveLeft(steps);
					else if(direction.equalsIgnoreCase("right")&&!board.contains(new FastPiece
							(null, null, board.get(i).getXpos()+1, board.get(i).getYpos())))
						board.get(i).moveRight(steps);
				}
			}
		}
	}
	public void printBoard()
	{
		boolean printed = false;
		for(int i=0; i<board.size(); i++)
			System.out.println(board.get(i));
		if(board.size()>0)
		{
			for(int j=0; j<8; j++)
			{
				for(int k=0; k<8; k++)
				{
					for(int i=0; i<board.size(); i++)
					{
						if(board.get(i).getXpos()==k&&board.get(i).getYpos()==j)
						{
							System.out.print(board.get(i).getName()+" ");
							printed = true;
						}
					}
					if(!printed)
						System.out.print("0 ");
					else printed = false;
				}
				System.out.println();
			}
		}
		else {
			for(int j=0; j<8; j++)
			{
				for(int k=0; k<8; k++)
				{
					System.out.print("0 ");
				}
				System.out.println();
			}
		}
	}
}