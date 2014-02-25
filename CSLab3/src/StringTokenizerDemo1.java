import java.util.*;
import java.io.*;
/**
 * @author Richard
 * @date 02/10/13
 */
public class StringTokenizerDemo1
{
	public static void main(String[] args) throws IOException
	{
		counting();
	}
	/**
	 * @throws IOException
	 * counts the lines, words, and characters in a file
	 */
	public static void counting() throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		String line, word;
		StringTokenizer token;
		int lines = 0, words = 0;
		ArrayList<Character> chars = new ArrayList<Character>();
		while (inputFile.hasNext())
		{
			line = inputFile.nextLine();
			lines++;
			token = new StringTokenizer(line, " ");
			while (token.hasMoreTokens())
			{
				word = token.nextToken();
				words++;
				char[] ch = word.toCharArray();
				for(int i=0; i<ch.length; i++)
					chars.add(ch[i]);
			}
		}
		System.out.println("Characters: "+chars.size()+"\nWords: "+words+"\nLines: "+lines);
		inputFile.close();
		keyboard.close();
	}
}