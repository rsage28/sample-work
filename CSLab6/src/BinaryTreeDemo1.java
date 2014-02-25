import java.util.ArrayList;
import java.util.Scanner;
/**
 * @author Richard
 * @date 30/10/13
 */
public class BinaryTreeDemo1
{
	public static void main(String[] args) 
	{
		ArrayList<BinaryTree<String>> make = makeTree();
		if(make.size()>0)
			print(make.get(0));
	}
	/**
	 * @return array list that contains all of the tree nodes. the first element is the root
	 */
	public static ArrayList<BinaryTree<String>> makeTree()
	{
		Scanner input = new Scanner(System.in);
		String keyboard;
		ArrayList<String> words = new ArrayList<String>();
		BinaryTree<String> tree = new BinaryTree<String>();
		ArrayList<BinaryTree<String>> make = new ArrayList<BinaryTree<String>>();
		int count = 0;
		//loop to fill the array list and attach nodes
		do{
			keyboard = input.next();
			if(!keyboard.equalsIgnoreCase("done"))
			{
				words.add(keyboard);
				tree.makeRoot(keyboard);
				make.add(tree);
			}
			/*if statements to test if the current node has two children, then attach next node to open slot.
			 *it always goes left then right.
			*/
			if((make.get(count).getLeft()==null||make.get(count).getRight()==null)
					&&!keyboard.equalsIgnoreCase("done"))
			{
				if(make.get(count).getLeft()==null&&make.get(count)!=make.get(make.size()-1))
					make.get(count).attachLeft(make.get(make.size()-1));
				else if(make.get(count).getRight()==null&&make.get(count)!=make.get(make.size()-1))
					make.get(count).attachRight(make.get(make.size()-1));
			}
			if(make.get(count).getLeft()!=null&&make.get(count).getRight()!=null)
				count++;
			tree = new BinaryTree<String>();
		}while(!keyboard.equalsIgnoreCase("done"));
		input.close();
		return make;
	}
	/**
	 * @param root root of the tree to be printed
	 * this method is printing all the required values
	 */
	public static void print(BinaryTree<String> root)
	{
		System.out.println("Height of tree: "+root.height());
		System.out.println("Number of nodes: "+root.numberOfNodes());
		System.out.print("Pre order:\t");
		BinaryTree.preorder(root);
		System.out.print("\nIn order:\t");
		BinaryTree.inorder(root);
		System.out.print("\nPost order:\t");
		BinaryTree.postorder(root);
		System.out.print("\nLevel order:\t");
		BinaryTree.levelOrder(root);
	}
}