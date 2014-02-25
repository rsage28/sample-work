import java.util.*;

/**
 * @author Richard
 * @date 03/10/13
 */
public class PracticeMoves
{
	public static void main(String[] args)
	{
		Board board = new Board();
		Scanner input = new Scanner(System.in);
		System.out.println("List of commands:\nCreate piece: [class name 1] [class name 2]" +
				" [xpos] [ypos] [name] [color]\nMove: [xpos] [ypos] [direction] [steps]" +
				"\nPrint\nHelp\nExit\nFirst type the name of the command, " +
				"then type in the parameters asked for, if they are listed.");
		String next;
		do{
			System.out.println("Command: ");
			next = input.nextLine();
			if(next.equalsIgnoreCase("create piece"))
				createPiece(board, input);
			else if(next.equalsIgnoreCase("move"))
				move(board, input);
			else if(next.equalsIgnoreCase("print"))
				board.printBoard();
			else if(next.equalsIgnoreCase("help"))
				help();
		}while(!next.equalsIgnoreCase("exit"));
		input.close();
	}
	/**
	 * @param b board containing pieces
	 * method to create a piece
	 */
	public static void createPiece(Board b, Scanner input)
	{
		System.out.println("Input parameters as shown without brackets: ");
		String cname1 = input.next();
		String cname2 = input.next();
		int xpos = Integer.parseInt(input.next());
		int ypos = Integer.parseInt(input.next());
		String name = input.next();
		String color = input.next();
		b.addNewPiece(cname1, cname2, xpos, ypos, name, color);
	}
	/**
	 * @param b board containing pieces
	 * method to move a piece
	 */
	public static void move(Board b, Scanner input)
	{
		System.out.println("Input parameters as shown without brackets: ");
		int xpos = Integer.parseInt(input.next());
		int ypos = Integer.parseInt(input.next());
		String direction = input.next();
		int steps = Integer.parseInt(input.next());
		b.movePiece(xpos, ypos, direction, steps);
	}
	/**
	 * method to print list of commands
	 */
	public static void help()
	{
		System.out.println("List of commands:\nCreate piece: [class name 1] [class name 2]" +
				" [xpos] [ypos] [name] [color]\nMove: [xpos] [ypos] [direction] [steps]" +
				"\nPrint\nHelp\nExit\nFirst type the name of the command, " +
				"then type in the parameters asked for, if they are listed.");
	}
}