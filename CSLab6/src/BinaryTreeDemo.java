/**
 * @author Richard
 * @date 30/10/13
 */
public class BinaryTreeDemo
{
	public static void main(String[] args)
	{
		//I added another node to test some of my methods
		BinaryTree<String> A = new BinaryTree<String>();
		BinaryTree<String> B = new BinaryTree<String>();
		BinaryTree<String> C = new BinaryTree<String>();
		BinaryTree<String> D = new BinaryTree<String>();
		BinaryTree<String> E = new BinaryTree<String>();
		BinaryTree<String> F = new BinaryTree<String>();
		BinaryTree<String> G = new BinaryTree<String>();
		A.makeRoot("A");
		B.makeRoot("B");
		C.makeRoot("C");
		D.makeRoot("D");
		E.makeRoot("E");
		F.makeRoot("F");
		G.makeRoot("G");

		A.attachLeft(B);
		A.attachRight(C);
		B.attachLeft(D);
		B.attachRight(E);
		D.attachLeft(F);
		C.attachLeft(G);

		System.out.print("Preorder:\t");
		BinaryTree.preorder(A);
		System.out.println();

		System.out.print("Inorder:\t");
		BinaryTree.inorder(A);
		System.out.println();

		System.out.print("Postorder:\t");
		BinaryTree.postorder(A);
		System.out.println();

		System.out.println("Number of nodes: "+A.numberOfNodes());
		System.out.println("Height of tree: "+A.height());
		System.out.println("Whether the tree is balanced: "+A.isBalanced());
		BinaryTree.levelOrder(A);
	}

}