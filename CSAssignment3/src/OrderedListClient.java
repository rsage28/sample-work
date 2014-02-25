import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
/**
 * @author Richard
 * @date 4/11/13
 */
public class OrderedListClient
{
	/**
	 * main method where the method calls are made
	 */
	public static void main(String[] args) 
	{
		OrderedList<Person> list1 = new OrderedList<Person>();
		OrderedList<Person> list2 = new OrderedList<Person>();
		File f1 = new File("names1.txt");
		File f2 = new File("names2.txt");
		list1 = readFiles(list1, f1);
		list2 = readFiles(list2, f2);
		performOperations(list1, list2);
	}
	/**
	 * @param list the ordered list to be filled
	 * @param f the file to read
	 * @return the filled ordered list
	 */
	public static OrderedList<Person> readFiles(OrderedList<Person> list, File f)
	{
		try {
			//variables needed to read file and put it in the list
			Scanner inFile = new Scanner(f);
			Person p;
			String line;
			StringTokenizer line2;
			while(inFile.hasNext())
			{
				line = inFile.nextLine();
				line2 = new StringTokenizer(line, "\t");
				p = new Person(line2.nextToken(), line2.nextToken(), Integer.parseInt(line2.nextToken()));
				list.insert(p);
			}
			inFile.close();
		}catch(FileNotFoundException e){System.out.println("error: "+e);}
		return list;
	}
	/**
	 * @param list1 list of names from names1.txt
	 * @param list2 list of names from names2.txt
	 */
	public static void performOperations(OrderedList<Person> list1, OrderedList<Person> list2)
	{
		//static method calls to create the merged, intersected, and difference lists
		OrderedList<Person> merged = OrderedListUtility.merge(list1, list2);
		OrderedList<Person> intersection = OrderedListUtility.findIntersection(list1, list2);
		OrderedList<Person> difference = OrderedListUtility.findDifference(list1, list2);
		//files to write to
		File l1 = new File("list1.txt");
		File l2 = new File("list2.txt");
		File merge = new File("mergedList.txt");
		File intersect = new File("intersectedList.txt");
		File dif = new File("differenceList.txt");
		//method call to write to files. more effecient than having a seperate for loop for each file
		printToFile(list1, l1);
		printToFile(list2, l2);
		printToFile(merged, merge);
		printToFile(intersection, intersect);
		printToFile(difference, dif);
	}
	/**
	 * @param list ordered list to be printed to a file
	 * @param f file to be printed to
	 */
	public static void printToFile(OrderedList<Person> list, File f)
	{
		try {
			PrintWriter outFile = new PrintWriter(f);
			for(int i = 0; i<list.size(); i++)
			{
				outFile.println(list.get(i).toString());
			}
			outFile.close();
		} catch (FileNotFoundException e) {e.printStackTrace();}		
	}
}