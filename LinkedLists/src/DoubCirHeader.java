/*************************************************************
 * Purpose:  Use the DoubleListNode class to write a Phrases 
 *  program that creates a circular, doubly linked list of the 
 *  phrases from h:\phrases.txt and prints them in a numbered 
 *  list. Then let the user input the number of a phrase and 
 *  print the list forward and backwards from that point.
 * 
 * For example if the original list of phrases is:

	1. I’m A Little Teapot
	2. Jack & Jill
	3. Mary Had A Little Lamb
	4. The Cat In The Hat
	5. The Little Engine That Could
	
	and the user inputs 3 your program should print:
	
	Forward:
	
	3. Mary Had A Little Lamb
	4. The Cat In The Hat
	5. The Little Engine That Could
	1. I’m A Little Teapot
	2. Jack & Jill
	
	Backwards:
	
	3. Mary Had A Little Lamb
	2. Jack & Jill
	1. I’m A Little Teapot
	5. The Little Engine That Could
	4. The Cat In The Hat

Hand in:  Copy your output to the bottom of your program, 
  print them and put your java file on the hand in disk.
  
*
* Written by: Richard Sage
* 
*************************************************************/
import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DoubCirHeader
{
	public static void fill(DoubleListNode head)
	{
		try{
			String file = JOptionPane.showInputDialog("what file?");
			Scanner inFile = new Scanner(new File(file));
			String phrase = inFile.nextLine();
			int count = 1;
			head.setValue(count +". "+ phrase);
			DoubleListNode newNode = head;
			
			while (inFile.hasNext()) {
				phrase = inFile.nextLine();
				count++;
				newNode.setNext(new DoubleListNode(count +". "+ phrase, head, newNode));
				newNode = newNode.getNext();
				head.setPrevious(newNode);
			}
			inFile.close();
		}catch (Exception e){
			System.out.println("error reading file: "+e);
		}
	}
	
	public static void print(DoubleListNode head)
	{
		int num = Integer.parseInt(JOptionPane.showInputDialog("Input a number to start with, 1-5:"));
		
		DoubleListNode t = head;
		DoubleListNode n = head;
		
		for(int i = 1; i<num; i++)
		{
			t = t.getNext();
			n = t;
		}		
		String list = "[";
		while(t.getNext() != n)
		{
			list += t.getValue() + "\n";
			t = t.getNext();
		}
		list += t.getValue() + "]";
		JOptionPane.showMessageDialog(null, list);
	}
	public static void printBackwards(DoubleListNode head)
	{
		int num = Integer.parseInt(JOptionPane.showInputDialog("Input a number to start with, 1-5:"));
		DoubleListNode t = head;
		DoubleListNode n = head;		
		for(int i = 1; i<num; i++)
		{
			t = t.getNext();
			n = t;
		}
		String list = "[";
		while(t.getPrevious() != n)
		{
			list += t.getValue() + "\n";
			t = t.getPrevious();
		}
		list += t.getValue() + "]";
		JOptionPane.showMessageDialog(null, list);
	}
	public static void main(String[] args)
	{
		DoubleListNode head = new DoubleListNode(null, null, null);
		head.setNext(head);
		head.setPrevious(head);
		fill(head);
		print(head);
		printBackwards(head);
	}
}
