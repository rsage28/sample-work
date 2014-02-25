import java.util.*;
import java.io.*;
/**
 * 
 * @author Richard
 * @date 02/10/13
 */

public class FileReadDemo
{
	public static void main(String[] args) throws IOException
	{
		ArrayList<String> names = new ArrayList<String>();
		sort(names);
	}
	/**
	 * @param names ArrayList to be sorted
	 */
	public static void sort(ArrayList<String> names) throws IOException
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the filename to read from: ");
		String filename = keyboard.nextLine();
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		while (inputFile.hasNext())
		{
			String line = inputFile.nextLine();
			if(names.isEmpty())
				names.add(line);
			for(int i=0; i<names.size()&&!names.contains(line); i++)
			{
				if(line.compareTo(names.get(i))<=0)
					names.add(i, line);
			}
			if(!names.contains(line))
				names.add(names.size(), line);
			for(int i=0; i<names.size(); i++)
			{
				System.out.print(names.get(i)+" ");
			}
			System.out.println();
		}		
		inputFile.close();
		keyboard.close();
	}
}