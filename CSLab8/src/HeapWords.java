import java.util.Scanner;
/**
 * @author Richard
 * @date 21/11/13
 */
public class HeapWords
{
	public static void main(String[] args) 
	{
		Heap<String> sort = new Heap<String>();
		Scanner input = new Scanner(System.in);
		String line=input.nextLine();
		while(!line.equals("-1"))
		{
			sort.add(line);
			line = input.nextLine();
		}
		input.close();
		sort.enumerate();
		/**
		 * testing the new methods
		 */
		System.out.println("Min: "+sort.findMin());
		System.out.println("Search Min: "+sort.findItem(sort.findMin()));
		System.out.println("Search \"\": "+sort.findItem(""));
		System.out.print("Priority change: ");
		sort.changePriority("derp", "herp");
		sort.enumerate();
		while(sort.size()>0)
			System.out.println(sort.deleteMax());
	}
}