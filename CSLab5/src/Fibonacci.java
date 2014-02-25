/**
 * @author Richard
 * @date 23/10/13
 */
public class Fibonacci
{
	public static void main(String[] args) 
	{
		//calling the recursive methods with various test values
		System.out.println("Fibonacci:"+ fibonacci(20)+"\n");
		System.out.println("Factorial: "+factorial(4)+"\n");
		System.out.println("Power: "+power(2, 4)+"\n");
		System.out.println("Blast Off: "+blastOff(10)+"\n");
		System.out.println("Every other blast off: "+blastOffTwo(10)+"\n");
		System.out.println("Every other blast off: "+blastOffTwo(9)+"\n");
		System.out.println("Multiples: ");
		multiples(2,5);
		System.out.println();
		System.out.println("Vertical: ");
		writeVertical(1234);
		System.out.println();
		System.out.println("Squares: "+squares(4)+"\n");
		System.out.println("Hanoi: "+hanoi(63));
	}
	/**
	 * @param n number of fibonacci numbers to print
	 * @return the nth fibonacci number
	 */
	public static int fibonacci(int n)
	{
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		else return fibonacci(n-1)+fibonacci(n-2);
	}
	/**
	 * @param n number to factorialize
	 * @return the result of taking the factorial of n
	 */
	public static int factorial(int n)
	{
		if(n==1)
			return 1;
		else return n*factorial(n-1);
	}
	/**
	 * @param x base
	 * @param n exponent
	 * @return final product
	 */
	public static int power(int x, int n)
	{
		if(n==0)
			return 1;
		else return power(x, n-1)*x;
	}
	/**
	 * @param n number to begin countdown
	 * @return "Blast Off!"
	 */
	public static String blastOff(int n)
	{
		if(n==0)
			return "Blast Off!";
		else
		{
			System.out.print(n+" ");
			return blastOff(n-1);
		}
	}
	/**
	 * @param n number to begin the countdown
	 * @return "Blast Off!"
	 */
	public static String blastOffTwo(int n)
	{
		if(n<=0)
			return "Blast Off!";
		else{
			System.out.print(n+" ");
			return blastOffTwo(n-2);
		}
	}
	/**
	 * @param n number producing multiples
	 * @param m which multiple the method is on
	 * @return the mth multiple of n
	 */
	public static int multiples(int n, int m)
	{
		if(m==1)
		{
			System.out.println(n);
			return n;
		}
		else
		{
			System.out.println(n*m);
			return n+multiples(n, m-1);
		}
	}
	/**
	 * @param n the number to be written
	 */
	public static void writeVertical(int n)
	{
		if(n==0)
			return;
		else
		{
			writeVertical(n/10);
			System.out.println(n%10);
		}
	}
	/**
	 * @param n number to begin squares with
	 * @return the sum of all squares 0-n
	 */
	public static int squares(int n)
	{
		if(n==0)
			return 0;
		else return (n*n)+squares(n-1);
	}
	/**
	 * @param n number of discs
	 * @return number of moves it takes to perform the transformation
	 */
	public static long hanoi(int n)
	{
		if(n==1)
			return 1;
		else return 2*hanoi(n-1)+1;
	}
}