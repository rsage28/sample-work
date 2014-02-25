import java.util.ArrayList;
/**
 * @author Richard 
 * @date 30/10/13
 * @param <T> generic class
 */
public class BinaryTree<T> 
{
	private T data;
	private BinaryTree<T> parent;
	private BinaryTree<T> left;
	private BinaryTree<T> right;

	public BinaryTree()
	{
		parent = left = right = null;
		data = null;
	}

	public void makeRoot(T data)
	{
		if (this.data != null)
		{
			System.out.println("Can't make root. Already exists");
		}
		else this.data = data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public void setLeft(BinaryTree<T> tree)
	{
		left = tree;
	}
	public void setRight(BinaryTree<T> tree)
	{
		right = tree;
	}
	public void setParent(BinaryTree<T> tree)
	{
		parent = tree;
	}

	public T getData()
	{
		return data;
	}
	public BinaryTree<T> getParent()
	{
		return parent;
	}
	public BinaryTree<T> getLeft()
	{
		return left;
	}
	public BinaryTree<T> getRight()
	{
		return right;
	}

	public void attachLeft(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (left!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{

			tree.setParent(this);
			this.setLeft(tree);
		}
	}

	public void attachRight(BinaryTree<T> tree)
	{
		if (tree==null) return;
		else if (right!=null || tree.getParent()!=null)
		{
			System.out.println("Can't attach");
			return;
		}
		else
		{

			tree.setParent(this);
			this.setRight(tree);
		}
	}

	public BinaryTree<T> detachLeft()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retLeft = left;
		left = null;
		if (retLeft!=null) retLeft.setParent(null);
		return retLeft;
	}
	public BinaryTree<T> detachRight()
	{
		if (this.isEmpty()) return null;
		BinaryTree<T> retRight = right;
		right =null;
		if (retRight!=null) retRight.setParent(null);
		return retRight;
	}
	public boolean isEmpty()
	{
		if (data == null)
			return true;
		else
			return false;
	}
	public void clear()
	{
		left = right = parent =null;
		data = null;
	}

	public BinaryTree<T> root()
	{
		if (parent == null)
			return this;
		else
		{
			BinaryTree<T> next = parent;
			while (next.getParent()!=null)
				next = next.getParent();
			return next;
		}
	}

	public static <T> void preorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			System.out.print(t.getData()+"\t");
			preorder(t.getLeft());	
			preorder(t.getRight());
		}
	}

	public static <T> void inorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			inorder(t.getLeft());
			System.out.print(t.getData() + "\t");
			inorder(t.getRight());
		}
	}

	public static <T> void postorder(BinaryTree<T> t)
	{
		if (t!=null)
		{
			postorder(t.getLeft());
			postorder(t.getRight());
			System.out.print(t.getData() + "\t");
		}
	}
	/**
	 * @return number of nodes in the tree
	 */
	public int numberOfNodes()
	{
		if(isEmpty())
			return 0;
		else if(left==null&&right==null)
			return 1;
		else if(left==null&&right!=null)
			return 1 + right.numberOfNodes();
		else if(left!=null&&right==null)
			return 1 + left.numberOfNodes();
		else return 1 + left.numberOfNodes() + right.numberOfNodes();
	}
	/**
	 * @return height (depth) of the tree
	 */
	public int height()
	{
		if(isEmpty())
			return 0;
		else if(left==null&&right==null)
			return 1;
		else if(left==null&&right!=null)
			return 1 + right.height();
		else if(left!=null&&right==null)
			return 1 + left.height();
		else return 1 + Math.max(left.height(), right.height());
	}
	/**
	 * @return whether or not the tree is balanced
	 */
	public boolean isBalanced()
	{
		if(left.height()==right.height()||left.height()==right.height()+1||right.height()==left.height()+1)
			return true;
		else return false;
	}
	/**
	 * @param t node of tree to start at
	 * prints the tree in order of level of the tree
	 */
	public static <T> void levelOrder(BinaryTree<T> t)
	{
		ArrayList<BinaryTree<T>> level = new ArrayList<BinaryTree<T>>();
		level.add(t);
		while(t!=null)
		{
			if(!level.isEmpty())
			{
				t = level.get(0);
				level.remove(0);
				System.out.print(t.getData() + "\t");

				if (t.getLeft() != null)
				{
					level.add(t.getLeft());
				}
				if (t.getRight() != null)
				{
					level.add(t.getRight());
				}
			}
			else return;
		}
	}
}