public class BSTNode <T extends Comparable<T>>
{
	private T value; BSTNode<T> left;
	private BSTNode<T> right;
	
	public BSTNode(T initValue)
		{ value = initValue; left = null; right = null; }
	
	public BSTNode(T initValue, BSTNode<T> initLeft, BSTNode<T> initRight)
	{ value = initValue; left = initLeft; right = initRight; }
	
	public T getValue() { return value; }
	public BSTNode<T> getLeft() { return left; }
	public BSTNode<T> getRight() { return right; }
	
	public void setValue(T theNewValue)  { value = theNewValue; }
	public void setLeft(BSTNode<T> theNewLeft)  { left = theNewLeft; }
	public void setRight(BSTNode<T> theNewRight)  { right = theNewRight; }	
	
}