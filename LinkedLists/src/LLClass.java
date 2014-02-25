/********************************************************************
 * Written by: Richard Sage
 * Period: 7
 *
 * ASSIGNMENT:  things that should be in your LinkList class:
 *
 * 	- a ListNode attribute called head
 * 	- a default constructor that sets head to null
 * 	- void addToEnd(Object o)
 * 	- void addToBeginning(Object o)
 * 	- void addInOrder(Comparable c) // pre-cond - list is in order
 * 	- String toString()
 * 	- int delete(Object o)	
 * 	- void clear()
 * 
 *	pre & post conditions for the methods
 *	a post condition for the constructor
 *
 * 	Your Runner should:
 * 
 *	1) Ask the user for 5 Strings and add to the end of the list.
 *	2) Print the list (using toString()).
 *	3) Clear the list.
 *	4) Ask the user for 5 Strings and add to the beginning of the list.
 *	5) Print the list (using toString()).
 *	6) Clear the list.
 *	7) Ask the user for 5 Strings and add in order
 *	8) Print the list (using toString()).
 *	9) Ask the user for a String to delete and print the new list.
 *		 Do this 4 times.
 *	10)Use JOP to do all of this.
 *
 *	HAND IN:  Print your LLClass and runner and hand in.
 *	Make a jar file and put it in my handin folder.
 *
 ********************************************************************/
public class LLClass
{
	ListNode head;
	public LLClass()
	{
		head=null;
	}
	public String toString()
	{
		ListNode trav=head;
		String list="[";
		while(trav!=null)
		{
			list+=trav.getValue()+", ";
			trav=trav.getNext();		
		}
		list+="]";
		return list;
	}
	public void addToEnd(Object o)
	{		
		if(head==null)
			head=new ListNode(o,null);
		else{
			ListNode l=head;
			while(l.getNext()!=null)
				l=l.getNext();
			l.setNext(new ListNode(o,null));
		}
	}
	public void addToBeginning(Object o)
	{
		head=new ListNode(o, head);
	}
	public void clear()
	{
		head=null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addInOrder(Comparable c)
	{
		if(head==null||c.compareTo(head.getValue())<=0)
			head=new ListNode(c, head);
		else
		{	
			ListNode trav=head;
			ListNode back=head;
			while(trav!=null && (c.compareTo(trav.getValue())>=0))
			{			
				back=trav;
				trav=trav.getNext();
			}
			back.setNext(new ListNode(c, trav));
		}
	}
	public boolean delete(Object o)
	{
		boolean b=false;
		if(head==null)
			return b;
		ListNode trav=head;
		while(trav.getNext()!=null)
		{
			if(trav.getValue()!=null&&trav.getValue().toString().equals(o.toString()))
			{
				trav.setValue(null);
				b=true;
			}
			trav=trav.getNext();
		}
		if(trav.getValue()!=null&&trav.getValue().toString().equals(o.toString()))
		{
				trav.setValue(null);
				b=true;
		}
		return b;
	}
}