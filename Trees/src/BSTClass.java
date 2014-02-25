/********************************************************************
Written by: Richard Sage

ASSIGNMENT:  Write a binary search tree class. 

Your class should have the following:
	one instance attribute - the root 
	a default construtor that sets root to null

Your class should have public methods that do the following:
	adds - takes a Comparable, returns nothing
	delete - takes a Comparable, returns the number deleted
	print the tree using pre, in & postorder traversals

Your class should have private methods that do the following:
	the recursive pre, in & postorder traversals
	delete no children, delete 1 child, delete 2 children
********************************************************************/
public class BSTClass <T extends Comparable<T>>
{
	private BSTNode<T> root;	
	public BSTClass()
	{
		root=null;
	}
	public BSTClass(BSTNode<T> r)
	{
		root=r;
	}
	public BSTNode<T> getRoot()
	{
		return root;
	}
	public void setRoot(BSTNode<T> r)
	{
		root=r;
	}
	public void add(T c)
	{
		if(root==null)
			setRoot(new BSTNode<T>(c));
		else
		{
			BSTNode<T> trav=root, back=root;
			while(trav!=null)
			{
				back=trav;
				if(c.compareTo(trav.getValue())<=0)
					trav=trav.getLeft();
				else trav=trav.getRight();
			}
			if(c.compareTo(back.getValue())<=0)
				back.setLeft(new BSTNode<T>(c));
			else back.setRight(new BSTNode<T>(c));
		}
	}
	public int delete(T c)
	{
		int count=0;
		BSTNode<T> trav=root, back=root;
		boolean found=false;
		while(trav!=null&&!found)
		{
			if(c.equals(trav.getValue()))
			{
				if(trav.getLeft()==null&&trav.getRight()==null)				
					deleteNoChild(trav, back);				
				else if(trav.getLeft()==null||trav.getRight()==null)				
					deleteOneChild(trav, back);
				else if(trav.getLeft()!=null&&trav.getRight()!=null)
					deleteTwoChildren(trav, back);
				count++;
				found=true;
			}
			if(c.compareTo(trav.getValue())<=0)
			{
				back=trav;
				trav=trav.getLeft();
			}
			else 	
			{
				back=trav;
				trav=trav.getRight();
			}
		}
		return count;
	}
	public int deleteAll(T c)
	{
		int count=0, returned;
		do{
			returned=delete(c);
			count+=returned;
		}while(returned!=0);
		return count;
	}
    public void deleteNoChild(BSTNode<T> trav, BSTNode<T> back)
	{
		if(back==trav)
			root=null;
		else if(back.getLeft()==trav)
			back.setLeft(null);
		else back.setRight(null);
	}
	private void deleteOneChild(BSTNode<T> trav, BSTNode<T> back)
	{
		if(back==trav)
		{
			if(trav.getLeft()!=null)
				root=trav.getLeft();
			else root=trav.getRight();
		}
		else if(trav.getRight()==null)
		{
			if(back.getLeft()==trav)
				back.setLeft(trav.getLeft());
			else back.setRight(trav.getLeft());
		}
		else if(trav.getLeft()==null)
		{
			if(back.getLeft()==trav)
				back.setLeft(trav.getRight());
			else back.setRight(trav.getRight());
		}
	}
	private void deleteTwoChildren(BSTNode<T> trav, BSTNode<T> back)
	{
		BSTNode<T> trav2=trav.getRight(), back2=trav;
		while(trav2.getLeft()!=null)
		{
			back2=trav2;
			trav2=trav2.getLeft();
		}
		trav.setValue(trav2.getValue());
		if(trav.getRight()!=null)
			deleteOneChild(trav2, back2);
		else deleteNoChild(trav2, back2);
	}
	public String print()
	{
		BSTNode<T> n=root;
		return "In Order:"+printInOrder(n)+"\nPre Order:"+
			printPreOrder(n)+"\nPost Order:"+printPostOrder(n);
	}
	private String printInOrder(BSTNode<T> node)
	{
		String answer="";
		if(node==null)
			return "";
		answer=printInOrder(node.getLeft())+node.getValue()+
			printInOrder(node.getRight());
		return answer;
	}
	private String printPreOrder(BSTNode<T> node)
	{
		String answer="";
		if(node==null)
			return "";
		answer=node.getValue()+printPreOrder(node.getLeft())+
			printPreOrder(node.getRight());
		return answer;
	}
	private String printPostOrder(BSTNode<T> node)
	{
		String answer="";
		if(node==null)
			return "";		
		answer=printPostOrder(node.getLeft())+
			printPostOrder(node.getRight())+node.getValue();
		return answer;
	}	
}