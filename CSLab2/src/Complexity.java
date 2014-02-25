import java.util.Scanner;
/**
 * 
 * @author Richard
 * @date 25/9/13
 */
public class Complexity
{
	public static void main(String[] args)
	{
		long startTime, endTime, executionTime;
		//get array size
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the size of the array: ");
		int n = input.nextInt();
		input.close();
		int[] myArray = new int[n];
		for(int i=0; i<n; i++)
			myArray[i]=(int)(Math.random()*500);
		startTime = System.currentTimeMillis();
		//method call
		bubbleSort(myArray);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		//print executionTime
		System.out.println(executionTime);
	}
	/** 
	 * @param myArray Array to be sorted
	 */
	public static void bubbleSort(int[] myArray)
	{
		//create temp and length variables
		int temp;
		int n=myArray.length;
		//bubble sort
		for (int pass = 1; pass< n; pass++)
		{
			for(int i=0;i< n-1;i++)
			{
				if(myArray[i]>myArray[i+1])
				{
					temp = myArray[i];
					myArray[i] = myArray[i+1];
					myArray[i+1] = temp;
				}
			}
		}
	}
}