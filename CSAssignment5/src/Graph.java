import java.util.*;
import java.io.*;
/**
 * @author Richard
 * @date 27/11/13
 */
public class Graph
{
	public static void main(String[] args) 
	{
		int[][] graph = readFile();
		print(graph);
		System.out.println();
		search(graph);
	}
	/**
	 * @param graph graph to print
	 */
	public static void print(int[][] graph)
	{
		int letter = 65;
		System.out.print("  ");
		for(int i = 0; i<graph.length; i++)
			System.out.print((char)letter+++" ");
		letter = 65;
		System.out.println();
		for(int i = 0; i<graph.length; i++){
			System.out.print((char)letter+++" ");
			for(int j = 0; j<graph[0].length; j++){
				System.out.print(graph[i][j]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * @param graph graph to fill
	 * @return filled graph
	 */
	public static int[][] readFile()
	{
		try {
			int[][] graph;
			Scanner inFile = new Scanner(new File("vertices.txt"));
			int x, y, size = inFile.nextInt();
			inFile.nextLine();
			String v1, v2;
			graph = new int[size][size];
			while(inFile.hasNext())
			{
				v1 = inFile.nextLine();
				v2 = inFile.nextLine();
				x = v1.charAt(0)-65;
				y = v2.charAt(0)-65;
				graph[x][y] = 1;
				graph[y][x] = 1;
			}
			inFile.close();
			return graph;
		} catch (FileNotFoundException e){System.out.println("error: "+e);}
		return null;
	}
	/**
	 * @param graph graph to search
	 */
	public static void search(int[][] graph)
	{
		ArrayList<Character> queue = new ArrayList<Character>();
		for(int i = 0; i<graph.length; i++)
		{
			if(!queue.contains((char)(i+65)))
				queue.add((char)(i+65));
			for(int j = 0; j<graph.length; j++)
			{
				if(graph[i][j]==1&&!queue.contains((char)(j+65)))
					queue.add((char)(j+65));
			}
		}
		for(Character c: queue)
			System.out.println(c.toString());
	}
}