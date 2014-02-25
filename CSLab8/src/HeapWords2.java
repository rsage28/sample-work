import java.util.Scanner;
/**
 * @author Richard
 * @date 21/11/13
 */
public class HeapWords2
{
	public static void main(String[] args) 
	{
		/**
		 * testing the min heap
		 */
		minHeap<String> sort = new minHeap<String>();
		Scanner input = new Scanner(System.in);
		String line=input.nextLine();
		while(!line.equals("-1"))
		{
			sort.add(line);
			line = input.nextLine();
		}
		input.close();
		while(sort.size()>0)
			System.out.println(sort.deleteMin());
	}
}