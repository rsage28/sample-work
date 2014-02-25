import java.util.Scanner;
public class PrintQueueDemo
{
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		PrintQueue myPQ = new PrintQueue();
		String name;
		int id;
		for(int i=1;i<=5;i++)
		{
			System.out.print("Enter owner and id: ");
			name = keyboard.next();
			id = keyboard.nextInt();
			myPQ.lpr(name,id);
		}
		System.out.println("Print Queue");
		myPQ.lpq();
		myPQ.lprm(101);
		myPQ.lprmAll("ronaldinho");
		System.out.println("Print Queue");
		System.out.println("\n\n");
		myPQ.lpq();
		keyboard.close();
	}
}