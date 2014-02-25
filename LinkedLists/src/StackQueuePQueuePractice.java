import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.swing.JOptionPane;

/********************************************************************
Written by: Richard Sage, Chris Hollrah
Date: 10/14/11

ASSIGNMENT:  Write a program that does the following:

- declares a Stack, a Queue and a Priority Queue of Strings.  
- asks the user to input Strings and add each String to each of your
	3 data structures.  The user should enter "zzz" to end.  Case 
	should not matter.
- prints the data in the 3 data structures, clearly labeled.

In what order was your Stack printed? order entered

In what order was your Queue printed? order entered

In what order was your Priority Queue printed? almost alphabetical

When you are finished printing, what is in your 3 data structures?  

the strings that were entered

HAND IN:  Answer the questions on the worksheet above, copy your 
output to the bottom and print. 

********************************************************************/
public class StackQueuePQueuePractice
{
	public static void main(String args[])
	{
		Stack<String> s=new Stack();
		Queue<String> q=new LinkedList();
		PriorityQueue<String> p=new PriorityQueue();
		String stuff=JOptionPane.showInputDialog("Input strings pl0x:");
		while(!stuff.equalsIgnoreCase("zzz"))
		{			
			s.push(stuff);
			q.add(stuff);
			p.add(stuff);
			stuff=JOptionPane.showInputDialog("Input strings pl0x:");
		}
		System.out.println("Stack "+s);
		System.out.println("Queue "+q);
		System.out.println("Priority Queue "+p);
	}
}
/*
Stack [e, d, c, b, a]
Queue [e, d, c, b, a]
Priority Queue [a, b, d, e, c]
*/