import java.util.Scanner;

public class Jumble
{
	public static void main(String[] args)
	{
		//create scanner
		Scanner in=new Scanner(System.in);
		//read in input
		System.out.println("Enter word to jumble: ");
		MyString toMix=new MyString(in.nextLine());
		System.out.println("Enter how many versions you want: ");
		int howMany=in.nextInt();
		in.close();
		//jumble the word
		System.out.println("String to jumble: "+toMix.toString());
		for(int i=0; i<howMany; i++)
			System.out.println(toMix.permute());
	}
}