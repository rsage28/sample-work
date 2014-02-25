import java.util.Scanner;
public class HeapDemo
{
	public static void main(String[] args)
	{
		Heap<Integer> myHeap = new Heap<Integer>();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter positive integers into the heap (-1 when done): ");
		Integer num = keyboard.nextInt();
		while (num!=-1)
		{
			myHeap.add(num);
			num = keyboard.nextInt();
		}
		//whoever writes the code keeps forgetting to close the Scanner.
		keyboard.close();
		myHeap.enumerate();

		System.out.println("Adding nodes 20, 67, 14, 2");
		myHeap.add(20);
		myHeap.enumerate();

		myHeap.add(67);
		myHeap.enumerate();

		myHeap.add(14);
		myHeap.enumerate();

		myHeap.add(2);
		myHeap.enumerate();

		System.out.println("Removing nodes on a priority basis");
		while (!myHeap.isEmpty())
		{
			System.out.println(myHeap.deleteMax());
			myHeap.enumerate();
		}
	}
}