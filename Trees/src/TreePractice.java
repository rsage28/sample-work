import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
/********************************************************************
Written by: Richard Sage
ASSIGNMENT:  Write a program that lets the user input a String and 
uses the TreeNode class to create a BST out of the characters in the 
String.  Then print your BST using pre, in and post order traversals.
All 3 traversals should be in ONE JOP window and should be clearly
labeled.
********************************************************************/
public class TreePractice
{
	public static void changeJOP()
	{
		UIManager.put("Label.font", new FontUIResource
				(new Font("Rockwell", Font.PLAIN, 20)));
		UIManager.put
			("OptionPane.messageForeground",new Color(0,0,205));
		UIManager.put("Panel.background",new Color(50,205,50));
		UIManager.put("OptionPane.background",new Color(0,0,205));
		UIManager.put("Button.background",new Color(255,215,0));
		UIManager.put("Button.foreground", new Color(255,20,147));
		UIManager.put("Button.font", new FontUIResource
				(new Font("Poor Richard", Font.PLAIN, 14)));
	}
	public static void fill(BSTNode<Character> trav, 
			BSTNode<Character> head, String s)
	{
		if(s.length()!=0)
		{
			char c=s.charAt(0);
			if(c<=trav.getValue())
			{
				if(trav.getLeft()==null)
				{
					trav.setLeft(new BSTNode<Character>(c));
					fill(head,head,s.substring(1));
				}
				else fill(trav.getLeft(),head,s);
			}
			else
			{
				if(trav.getRight()==null)
				{
					trav.setRight(new BSTNode<Character>(c));
					fill(head,head,s.substring(1));
				}
				else fill(trav.getRight(),head,s);
			}
		}
	}
	public static String printInOrder(BSTNode<Character> node)
	{
		String answer="";
		if(node==null)
			return "";
		answer+=printInOrder(node.getLeft());
		answer+=node.getValue();
		answer+=printInOrder(node.getRight());
		return answer;
	}
	public static String printPreOrder(BSTNode<Character> node)
	{
		String answer="";
		if(node==null)
			return "";
		answer+=node.getValue();
		answer+=printPreOrder(node.getLeft());
		answer+=printPreOrder(node.getRight());
		return answer;
	}
	public static String printPostOrder(BSTNode<Character> node)
	{
		String answer="";
		if(node==null)
			return "";		
		answer+=printPostOrder(node.getLeft());
		answer+=printPostOrder(node.getRight());
		answer+=node.getValue();
		return answer;
	}
	public static void main(String derp[])
	{
		changeJOP();
		String word=JOptionPane.showInputDialog("Enter a string: ");
		String ans="";
		BSTNode<Character> head=new BSTNode<Character>(word.charAt(0));
		fill(head,head, word.substring(1));
		ans+="In Order: "+printInOrder(head)+"\n";
		ans+="Pre Order: "+printPreOrder(head)+"\n";
		ans+="Post Order: "+printPostOrder(head)+"\n";
		JOptionPane.showMessageDialog(null, ans);
	}
}