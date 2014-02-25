import java.util.Scanner;
/**
 * 
 * @author Richard
 * @date 25/9/13
 */
public class MatrixMult {
	/** Main method */
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int n;
		double num;
		System.out.print("Enter the size of each matrix: ");
		n = keyboard.nextInt();
		System.out.println("Enter the matrix element");
		System.out.print("All elements of the matrices are assumed to be the same: ");
					num = keyboard.nextDouble();
		double[][] matrix1 = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix1[i][j] = num;
		double[][] matrix2 = new double[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				matrix2[i][j] = num;
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Execution time: " + executionTime + " millisecs");
	}
	/** The method for multiplying two matrices 
	 *  @param m1, m2 two matricies to be multiplied
	 */
	public static double[][] multiplyMatrix(double[][] m1, double[][] m2)
	{
		int sum=0;
		double[][] fin=new double[m1.length][m1[0].length];
		//multiplying the matricies
		for(int i=0; i<m1.length; i++)
		{
			for(int j=0; j<m1[0].length; j++)
			{
				for(int l=0; l<m1.length; l++)
					sum+=m1[i][j]*m2[j][i];
				fin[i][j]=sum;
				sum=0;
			}			
		}
		return fin;
	}
}