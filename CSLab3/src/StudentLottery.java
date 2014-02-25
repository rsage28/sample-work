import java.util.*;

/**
 * @author Richard
 * @date 01/10/13
 */
public class StudentLottery
{
	/**
	 * attributes
	 */
	private ArrayList<Student> list;
	/**
	 * constructor
	 */
	public StudentLottery()
	{
		list = new ArrayList<Student>();
	}
	/**
	 * method to add students to the ArrayList
	 */
	public void addStudents()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Would you like to enter? y or n");
		String cont = input.nextLine();
		String name, id;
		Student person;
		while(cont.equals("y"))
		{
			System.out.println("Name: ");
			name = input.nextLine();
			System.out.println("ID: ");
			id = input.nextLine();
			person = new Student(id, name);
			if(!list.contains(person))
				list.add(person);
			else System.out.println("Sorry, you cannot enter the same student twice");
			System.out.println("Would you like to enter? y or n");
			cont = input.nextLine();
		}
		input.close();
	}
	/**
	 * @return randomly chosen student
	 */
	public void pickWinner()
	{
		System.out.println("Winner: "+list.get((int)(Math.random()*list.size())));
	}
}