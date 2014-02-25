public class BinarySearchTree<T extends Comparable<T>> 
{
	private BinaryTree<T> tree;
	int size;

	public BinarySearchTree()
	{
		tree = new BinaryTree<T>();
		size = 0;
	}
	public BinaryTree<T> getTree()
	{
		return tree;
	}

	public boolean isEmpty()
	{
		return tree.isEmpty();
	}

	public int size()
	{
		return size;
	}

	public BinaryTree<T> search(T key)
	{
		BinaryTree<T> t = tree;
		boolean found = false;
		while(!found&&t!=null)
		{
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else
				found = true;
		}
		if (found)
			return t;
		else
			return null;
	}


	public void insert(T item)
	{
		if (tree.isEmpty())
		{
			tree.makeRoot(item);
			size++;
			return;
		}
		BinaryTree<T> t = tree;
		boolean done = false;
		//BinaryTree<T> newNode = null;
		while (!done)
		{
			int c = item.compareTo(t.getData());
			if (c==0)
			{
				System.out.println("Duplicate item. Can't insert");
				done=true;
			}
			else if (c<0)
			{
				if (t.getLeft()==null)
				{
					BinaryTree<T> newNode = new BinaryTree<T>();
					t.setLeft(newNode);
					newNode.setParent(t);
					newNode.setData(item);
					done = true;
					size++;
				}
				else
					t = t.getLeft();
			}
			else if (c>0)
			{
				if (t.getRight()==null)
				{
					BinaryTree<T> newNode = new BinaryTree<T>();
					t.setRight(newNode);
					newNode.setParent(t);
					newNode.setData(item);
					done = true;
					size++;
				}
				else
					t = t.getRight();
			}

		}

	}

	public BinaryTree<T> findPredecessor(BinaryTree<T> node)
	{
		//if (node==null)
		//return null;
		if (node.getLeft()==null)
			return null;
		BinaryTree<T> pred = node.getLeft();
		while (pred.getRight()!=null)
			pred = pred.getRight();

		return pred;

	}

	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach)
	{
		BinaryTree<T> parent = deleteNode.getParent();
		deleteNode.clear();
		if (parent == null)
			return;
		if (attach == null){ 
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);

			deleteNode.setParent(null);
			return;
		}

		if (deleteNode==parent.getLeft())
		{
			parent.detachLeft();
			attach.setParent(null);
			parent.attachLeft(attach);
		}
		else
		{
			parent.detachRight();
			attach.setParent(null);
			parent.attachRight(attach);
		}
	}

	public void delete(T key)
	{

		if (tree.isEmpty()){System.out.println("Can't delete. Empty tree"); return;}

		BinaryTree<T> deleteNode = search(key);

		if (deleteNode == null){System.out.println("Can't delete. Key not found"); return;}

		BinaryTree<T> hold = null;

		if (deleteNode.getLeft()==null && deleteNode.getRight()==null)
		{
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null)
		{
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
		else if (deleteNode.getRight()==null)
		{
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else
		{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode = hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
		size--;
	}
	/**
	 * @param temp the current node of the BST
	 * @return the data of the max node
	 */
	public T findMax(BinaryTree<T> temp)
	{
		if(temp.getRight()==null)
			return temp.getData();
		else return findMax(temp.getRight());
	}
	/**
	 * @param temp the current node of the BST
	 * @return the data of the min node
	 */
	public T findMin(BinaryTree<T> temp)
	{
		if(temp.getLeft()==null)
			return temp.getData();
		else return findMin(temp.getLeft());
	}
	/**
	 * @param key the data being searched for
	 * @return the tree with the key
	 */
	public BinaryTree<T> recursiveSearch(T key)
	{
		if (tree.isEmpty())
			return null;
		else return recursiveSearch(tree, key);
	}
	/**
	 * @param t the tree being searched on this pass
	 * @param key the data to search for
	 * @return the tree with the key
	 */
	public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key)
	{
		if(t.getData().equals(key))
			return t;
		else if(t.getData().compareTo(key)<0&&t.getRight()!=null)
			return recursiveSearch(t.getRight(), key);
		else if(t.getData().compareTo(key)>0&&t.getLeft()!=null) 
			return recursiveSearch(t.getLeft(), key);
		else return null;
	}
	/**
	 * @param t the tree being tested
	 * @return whether the tree is a binary search tree
	 */
	public boolean isBST(BinaryTree<T> t)
	{
		if(t.getLeft()==null&&t.getRight()==null)
			return true;
		else if(t.getLeft()!=null&&t.getData().compareTo(t.getLeft().getData())<0)
			return false;
		else if(t.getRight()!=null&&t.getData().compareTo(t.getRight().getData())>0)
			return false;
		else
		{
			if(t.getLeft()!=null&&t.getRight()!=null)
				return (isBST(t.getLeft())&&isBST(t.getRight()));
			else if(t.getLeft()!=null&&t.getRight()==null)
				return isBST(t.getLeft());
			else return isBST(t.getRight());
		}
	}
	/**
	 * @param t1 the first BST to be merged
	 * @param t2 the second BST to be merged
	 * @return the merged BST
	 */
	public static <T extends Comparable<T>> BinarySearchTree<T> merge(BinarySearchTree<T> t1, 
			BinarySearchTree<T> t2)
	{
		/*
		 * This was my original method. However, I've discovered an error in the delete methods given to us.
		 * When the tree is in linked list form i.e. all nodes are greater or less than their parents,
		 * it deletes the entire tree instead of just the root node. This caused errors in my algorithm.
		 * Therefore, I have to do it another way. I believe this method would work if the error were 
		 * not there though. I don't have time to fix the error myself, so I'm just going to start over.
		BinarySearchTree<T> temp1 = t1;
		BinarySearchTree<T> temp2 = t2;
		BinarySearchTree<T> toReturn = new BinarySearchTree<T>();
		while(!temp1.isEmpty()&&!temp2.isEmpty())
		{
			toReturn.insert(temp1.getTree().root().getData());
			toReturn.insert(temp2.getTree().root().getData());
			temp1.delete(temp1.getTree().root().getData());
			temp2.delete(temp2.getTree().root().getData());
		}
		if(!temp1.isEmpty())
		{
			while(!temp1.isEmpty())
			{
				toReturn.insert(temp1.getTree().root().getData());
				temp1.delete(temp1.getTree().root().getData());
			}
		}
		else if(!temp2.isEmpty())
		{
			while(!temp2.isEmpty())
			{
				toReturn.insert(temp2.getTree().root().getData());
				temp1.delete(temp2.getTree().root().getData());
			}
		}
		return toReturn;
		*/
		BinarySearchTree<T> toReturn = new BinarySearchTree<T>();
		BinarySearchTree<T> temp1 = t1;
		BinarySearchTree<T> temp2 = t2;
		if(t1!=null&&t2!=null)
		{
			toReturn.insert(temp1.getTree().root().getData());
			toReturn.insert(temp2.getTree().root().getData());
		}
		while(!temp1.isEmpty()&&!temp2.isEmpty())
		{
			toReturn.insert(temp1.findMin(temp1.getTree()));
			toReturn.insert(temp1.findMax(temp1.getTree()));
			toReturn.insert(temp2.findMin(temp2.getTree()));
			toReturn.insert(temp2.findMax(temp2.getTree()));
			temp1.delete(temp1.findMin(temp1.getTree()));
			temp1.delete(temp1.findMax(temp1.getTree()));
			temp2.delete(temp2.findMin(temp2.getTree()));
			temp2.delete(temp2.findMax(temp2.getTree()));
		}
		if(!temp1.isEmpty())
		{
			while(!temp1.isEmpty())
			{
				toReturn.insert(temp1.findMin(temp1.getTree()));
				if(!temp1.findMin(temp1.getTree()).equals(temp1.findMax(temp1.getTree())))
					toReturn.insert(temp1.findMax(temp1.getTree()));
				if(!temp1.findMin(temp1.getTree()).equals(temp1.findMax(temp1.getTree())))
				{
					temp1.delete(temp1.findMin(temp1.getTree()));
					temp1.delete(temp1.findMax(temp1.getTree()));
				}
				else temp1.delete(temp1.findMin(temp1.getTree()));
			}
		}
		else if(!temp2.isEmpty())
		{
			while(!temp2.isEmpty())
			{
				toReturn.insert(temp2.findMin(temp2.getTree()));
				if(!temp2.findMin(temp2.getTree()).equals(temp2.findMax(temp2.getTree())))
					toReturn.insert(temp2.findMax(temp2.getTree()));
				if(!temp2.findMin(temp2.getTree()).equals(temp2.findMax(temp2.getTree())))
				{
					temp2.delete(temp2.findMin(temp2.getTree()));
					temp2.delete(temp2.findMax(temp2.getTree()));
				}
				else temp2.delete(temp2.findMin(temp2.getTree()));
			}
		}
		return toReturn;
	}
}