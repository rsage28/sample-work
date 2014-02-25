public class BinarySearchTreeDemo
{
	public static void main(String[] args)
	{
		//first tree
		BinarySearchTree<String> myTree = new BinarySearchTree<String>();
		myTree.insert("E");
		myTree.insert("B");
		myTree.insert("K");
		myTree.insert("M");
		myTree.insert("C");
		myTree.insert("Z");
		myTree.insert("D");
		//second tree
		BinarySearchTree<String> myTree2 = new BinarySearchTree<String>();
		myTree2.insert("H");
		myTree2.insert("I");
		myTree2.insert("A");
		myTree2.insert("O");
		myTree2.insert("G");
		myTree2.insert("S");
		myTree2.insert("F");
		//test of max, min, and isBST
		System.out.println("Max: "+myTree.findMax(myTree.getTree()));
		System.out.println("Min: "+myTree.findMin(myTree.getTree()));
		System.out.println("Is binary search tree: "+myTree.isBST(myTree.getTree()));
		//normal search
		BinaryTree<String> treenode = myTree.search("A");
		System.out.println("Normal search for A: ");
		if (treenode!=null)
			System.out.println(treenode.getData() + " found");
		else
			System.out.println("not found");
		//recursive search
		BinaryTree<String> treenode2 = myTree.recursiveSearch("A");
		System.out.println("Recursive search for A: ");
		if (treenode2!=null)
			System.out.println(treenode2.getData() + " found");
		else
			System.out.println("not found");
		//normal search
		BinaryTree<String> treenode3 = myTree.search("B");
		System.out.println("Normal search for B: ");
		if (treenode3!=null)
			System.out.println(treenode3.getData() + " found");
		else
			System.out.println("not found");
		//recursive search
		BinaryTree<String> treenode4 = myTree.recursiveSearch("B");
		System.out.println("Recursive search for B: ");
		if (treenode4!=null)
			System.out.println(treenode4.getData() + " found");
		else
			System.out.println("not found");

		System.out.println("Deleting nodes");
		myTree.delete("Z");
		BinaryTree.inorder(myTree.getTree());
		System.out.println();

		myTree.delete("B");
		BinaryTree.inorder(myTree.getTree());
		System.out.println();

		myTree.delete("K");
		BinaryTree.inorder(myTree.getTree());
		System.out.println();

		myTree.delete("E");
		BinaryTree.inorder(myTree.getTree());
		System.out.println();

		myTree.delete("M");
		myTree.delete("D");
		BinaryTree.inorder(myTree.getTree());
		System.out.println();
		//remaking the tree
		myTree.insert("E");
		myTree.insert("B");
		myTree.insert("K");
		myTree.insert("M");
		myTree.insert("C");
		myTree.insert("Z");
		myTree.insert("D");
		//merging the trees
		BinarySearchTree<String> merged = BinarySearchTree.merge(myTree, myTree2);
		System.out.println("Merged tree: ");
		BinaryTree.inorder(merged.getTree());
		
	}

}