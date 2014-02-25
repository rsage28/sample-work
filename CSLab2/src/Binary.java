import java.util.Scanner;
/**
 * 
 * @author Richard
 * @date 25/9/13
 */
public class Binary
{
	public static void main(String[] args)
	{
		long startTime, endTime, executionTime;
		//power of 2
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the power of 2: ");
		int n = input.nextInt();
		input.close();
		startTime = System.currentTimeMillis();
		//method call
		convert(n);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		//print executionTime
		System.out.println("Execution time: " + executionTime + " millisecs");
	}
	/**
	 * 
	 * @param n the power 2 will be raised to
	 */
	public static void convert(int n)
	{
		//generating number of run times
		int run=(int)(Math.pow(2, n));
		//simulation loop
		for(int i=0; i<run; i++)
		{
			String sb = Integer.toBinaryString(i);
		}
	}
}