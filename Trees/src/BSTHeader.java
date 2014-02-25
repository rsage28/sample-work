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

Write a BSTRunner file that does the following:
	asks the user to input a string
	creates an instance of your BST class using the characters
		in the input string
	prints the tree using TreePainter.java
	prints a menu in a JOptionPane that lets the user choose to
		add, delete, print or exit.  
		Add & delete should ask the user what character to add or
			delete.  The updated tree should show up in the
			TreePainter window.  
		Print should print the pre, in & postorder traversals  
********************************************************************/
