/**
 * @author Richard
 * @param <T>
 * @date 16/10/13
 */
public class Queue<T>
{
	/**
	 * attributes
	 */
	private LinkedList<T> list;
	private int cursor; //the cursor is mainly used for the first and the next methods.
	private int counter;
	private Node<T> pos;
	/**
	 * constructor
	 */
	public Queue()
	{
		list = new LinkedList<T>();
		counter = 0;
		cursor = 0;
	}
	/**
	 * @param item item to be added 
	 */
	public void enqueue(T item)
	{
		list.addToEnd(item);
		counter++;
	}
	/**
	 * @return item that is being dequeued
	 */
	public T dequeue()
	{
		T item = list.getFront().getData();
		list.remove(item);
		return item;
	}
	/**
	 * @return size of the Queue
	 */
	public int size()
	{
		return counter;
	}
	/**
	 * @return whether the Queue is empty
	 */
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	/**
	 * clear the entire Queue
	 */
	public void clear()
	{
		list.clear();
	}
	/**
	 * @return the first entry in the queue without dequeueing it
	 */
	public T peek()
	{
		return list.getFront().getData();
	}
	/**
	 * @param item item to be searched for
	 * @return position of the item in the Queue
	 */
	public int positionOf(T item)
	{
		int toReturn = list.getPosition(item);
		return toReturn;
	}
	/**
	 * @return first data entry in the Queue
	 */
	public T first()
	{
		if(!isEmpty())
		{
			pos = list.getFront();
			return pos.getData();
		}
		else return null;
	}
	/**
	 * @return next data entry in the Queue after the last data entry printed
	 */
	public T next()
	{
		if(pos.getNext() != null && pos != null)
		{
			pos = pos.getNext();
			cursor++;
			return pos.getData();
		}
		else return null;
	}
	/**
	 * @param item instance of item to remove all of from the Queue
	 */
	public void remove(T item)
	{
		list.remove(item);
		counter--;
	}
}