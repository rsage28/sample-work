/******************************************************************************
Class name:  DoubleListNode

ListNode modified by:  Hadley Steelman

Saved as: DoubleListNode.java

Other files:
		none

******************************************************************************/


public class DoubleListNode
{
	// instance properties
	
	private Object value;
	private DoubleListNode next;
	private DoubleListNode previous;
	
	
	// constructor
	
	public DoubleListNode (Object initValue,
					 		DoubleListNode initNext,
					 		DoubleListNode initPrevious)
	// pre-condition: initValue is a valid Object, initNext is valid 
	//	DoubleListNode and initPrevious is a valid DoubleListNode.
	// post-condition: value equals initValue, next equals initNext and
	//	previous equals initPrevious.
	{
		value = initValue;
		next = initNext;
		previous = initPrevious;
		return;
	}
	
	
	// accessors
	
	public Object getValue ()
	// pre-condition: value is either null or a valid Object.
	// post-condition: value is returned.
	{
		return value;
	}
	
	public DoubleListNode getNext ()
	// pre-condition: next is either null or a valid DoubleListNode.
	// post-condition: next is returned.
	{
		return next;
	}

	public DoubleListNode getPrevious ()
	// pre-condition: previous is either null or a valid DoubleListNode.
	// post-condition: previous is returned.
	{
		return previous;
	}
	
	
	// mutators
	
	public void setValue (Object theNewValue)
	// pre-condition: theNewValue is a valid Object.
	// post-condition: value equals theNewValue.
	{
		value = theNewValue;
	}
	
	public void setNext (DoubleListNode theNewNext)
	// pre-condition: theNewNext is a valid DoubleListNode.
	// post-condition: next equals theNewNext.
	{
		next = theNewNext;
	}

	public void setPrevious (DoubleListNode theNewPrevious)
	// pre-condition: theNewPrevious is a valid DoubleListNode.
	// post-condition: previous equals theNewPrevious
	{
		previous= theNewPrevious;
	}

}

