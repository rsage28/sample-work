import java.io.*;
import java.util.*;
/**
 * @author Richard
 * @date 19/11/13
 */
public class Huffman
{
	public static void main(String[] args) 
	{
		/**
		 * method calls to read the file, make the queue, and build the tree, then print the tree
		 */
		ArrayList<Pair> symbols = readFile();
		bubbleSort(symbols);
		ArrayList<BinaryTree<Pair>> s = makeQueue(symbols);
		ArrayList<BinaryTree<Pair>> t = new ArrayList<BinaryTree<Pair>>();
		buildHuffman(s,t);
		String[] encoded = findEncoding(t.get(0));
		writeToFile(encoded);
	}
	/**
	 * @return the ArrayList of the symbols
	 */
	public static ArrayList<Pair> readFile()
	{
		ArrayList<Pair> symbols = new ArrayList<Pair>();
		try {
			Scanner inFile = new Scanner(new File("symbols.txt"));
			String line;
			Pair p;
			String[] split;
			while(inFile.hasNext())
			{
				line = inFile.nextLine();
				split = line.split(" ");
				p = new Pair(split[0].charAt(0), Integer.parseInt(split[1]));
				symbols.add(p);
			}
			inFile.close();
		} catch (FileNotFoundException e){System.out.println("error: "+e);}
		return symbols;
	}
	/**
	 * @param symbols the array list to be sorted
	 */
	public static void bubbleSort(ArrayList<Pair> symbols)
	{
		for (int i = 0; i < symbols.size(); i++) {
			for (int x = 1; x < symbols.size()-i; x++) {
				if (symbols.get(x - 1).compareTo(symbols.get(x))>0) {
					Pair temp = symbols.get(x-1);
					symbols.set(x-1, symbols.get(x));
					symbols.set(x, temp);
				}
			}
		}
	}
	/**
	 * @param symbols the sorted array list of symbols
	 * @return the array list acting as the queue
	 */
	public static ArrayList<BinaryTree<Pair>> makeQueue(ArrayList<Pair> symbols)
	{
		ArrayList<BinaryTree<Pair>> toReturn = new ArrayList<BinaryTree<Pair>>();
		BinaryTree<Pair> add;
		for(Pair p: symbols)
		{
			add = new BinaryTree<Pair>();
			add.makeRoot(p);
			toReturn.add(add);
		}
		return toReturn;
	}
	/**
	 * @param s queue with the symbols
	 * @param t the queue making the tree
	 */
	public static void buildHuffman(ArrayList<BinaryTree<Pair>> s, ArrayList<BinaryTree<Pair>> t)
	{
		BinaryTree<Pair> a;
		BinaryTree<Pair> b;
		BinaryTree<Pair> p;
		Pair n;
		while(s.size()>0)
		{
			a = new BinaryTree<Pair>();
			b = new BinaryTree<Pair>();
			p = new BinaryTree<Pair>();
			if(t.size()==0&&s.size()>1)
			{
				a = s.get(0);
				s.remove(0);
				b = s.get(0);
				s.remove(0);
			}
			else 
			{
				if(s.get(0).getData().getFreq()>t.get(0).getData().getFreq())
				{
					a = t.get(0);
					t.remove(0);
					if(s.size()>0&&s.get(0).getData().getFreq()>t.get(0).getData().getFreq())
					{
						b = t.get(0);
						t.remove(0);
					}
					else
					{
						b = s.get(0);
						s.remove(0);
					}
				}
				else
				{
					a = s.get(0);
					s.remove(0);
					if(s.size()>0&&s.get(0).getData().getFreq()>t.get(0).getData().getFreq())
					{
						b = s.get(0);
						s.remove(0);
					}
					else
					{
						b = t.get(0);
						t.remove(0);
					}
				}
			}
			if(a.getData()!=null&&b.getData()!=null)
			{
				n = new Pair(' ', a.getData().getFreq()+b.getData().getFreq());
				p.makeRoot(n);
				p.attachLeft(a);
				p.attachRight(b);
				t.add(p);
			}
			else
			{
				if(a.getData()!=null)
					t.add(a);
				else if(b.getData()!=null)
					t.add(b);
				else return;
			}
		}
		while(t.size()>1)
		{
			a = new BinaryTree<Pair>();
			b = new BinaryTree<Pair>();
			p = new BinaryTree<Pair>();	
			a = t.get(0);
			b = t.get(1);
			n = new Pair(' ', a.getData().getFreq()+b.getData().getFreq());
			p.makeRoot(n);
			p.attachLeft(a);
			p.attachRight(b);
			t.add(p);
		}
	}
	/**
	 * @param t the huffman tree
	 * @param a the array to store the representations
	 * @param prefix building the path for each character
	 */
	public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix)
	{
		if (t.getLeft()==null&& t.getRight()==null)
		{
			a[(byte)(t.getData().getValue())]= prefix;
		}
		else
		{
			findEncoding(t.getLeft(), a, prefix+"0");
			findEncoding(t.getRight(), a, prefix+"1");
		}
	}
	/**
	 * @param t huffman tree
	 * @return array of paths for each character
	 */
	public static String[] findEncoding(BinaryTree<Pair> t)
	{
		String[] result = new String[256];
		findEncoding(t, result, "");
		return result;
	}
	public static void writeToFile(String[] encoded)
	{
		try {
			PrintWriter inFile = new PrintWriter(new File("tree.txt"));
			for(int i = 0; i<encoded.length; i++)
			{
				if(encoded[i]!=null)
				{
					inFile.print((char)i+": ");
					inFile.println(encoded[i]);
				}
			}
			inFile.close();
		} catch (FileNotFoundException e) {System.out.println("error: "+e);}
	}
}