import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/********************************************************************
Written by: Richard Sage

ASSIGNMENT:  To write a program that creates a Song database using 
sets & maps.
The song names will be read from a data file (you should ask for the 
name of the file).
Each word in a song name will be mapped to EVERY song in the data 
file that contains that word.  
If a word is in a song title more than once the title should only be
listed once.
You should print you song map in a JOP window in the following format:
word 1: [song 1, song 2, etc... ]
word 2: [song 1, song 4, etc...]

After you close the JOP window you should print a menu that gives the
user a choice of searching, adding, deleting, printing or exiting.
- Searching: ask the user to input a word to search for.  If the word 
is found you should print the number of songs that contain that word
and every song title that contains that word. Otherwise you should 
print a polite message saying the word wasn't found.
Upper or lower case shouldn't matter.  A == a is true!
I should not have ANY trouble reading your JOP windows!
- Adding:  let the user input a song title and add the words & the
title to the tree.
- Deleting:  let the user input a song title and delete the song 
from the tree.
- Printing:  prints the JOP of the map again.
- Exit: ends the program!

You should have fairly short methods and no duplicate code.  If 
you are doing the same thing in several methods you should put that
code in a separate method and call it.

HAND IN:  Make a jar file and print.

GRADING:  50 points

_____  Your map is created correctly (10 points)
_____  Search works (5 points)
_____  Add works (10 points)
_____  Delete works (10 points)
_____  Print works (5 points)
_____  Formatting (5 points)
_____  Program structure (no duplicate code, method lengths, etc...) 
		(5 points)


********************************************************************/
public class SongMap
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
	public static void fill(String fileName, 
			TreeMap<String, HashSet<String>> songs,
			HashSet<String> words,HashSet<String> names)
	{
		try{
			Scanner inFile=new Scanner(new File(fileName));			
			while(inFile.hasNext())
			{
				String line=inFile.nextLine();
				String[] name=line.split(" ");
				names.add(line);
				for(int i=0; i<name.length; i++)
					words.add(name[i]);	
			}
			inFile.close();
		}catch(Exception e){System.out.println("error: "+e);}
		Iterator<String> make=words.iterator();
		while(make.hasNext())
		{
			String word=make.next();
			songs.put(word, makeMap(names, word));
		}
	}
	public static void checkKeys(TreeMap<String, HashSet<String>> songs)
	{
		Iterator<String> words=songs.keySet().iterator();
		ArrayList<String> checkAll=new ArrayList<String>();
		ArrayList<String> toDelete=new ArrayList<String>();
		while(words.hasNext())
			checkAll.add(words.next());
		for(int i=0; i<checkAll.size(); i++)
			for(int j=i+1; j<checkAll.size(); j++)
				if(checkAll.get(i).equalsIgnoreCase(checkAll.get(j)))
				{
					toDelete.add(checkAll.get(j));
					checkAll.remove(checkAll.get(j));
				}
		for(String s: toDelete)
			songs.remove(s);			
	}
	public static HashSet<String> makeMap(HashSet<String> names, 
			String word)
	{
		HashSet<String> songs=new HashSet<String>();
		Iterator<String> name=names.iterator();
		while(name.hasNext())
		{
			String n=name.next();
			String[] song=n.split(" ");
			for(int i=0; i<song.length; i++)
				if(song[i].equalsIgnoreCase(word))
					songs.add(n);
		}
		return songs;
	}
	public static void add(TreeMap<String, HashSet<String>> songs,
			HashSet<String> words,HashSet<String> names)
	{
		String toAdd=JOptionPane.showInputDialog("add?");
		names.add(toAdd);
		String[] line=toAdd.split(" ");
		for(int i=0; i<line.length; i++)
			words.add(line[i]);
		Iterator<String> make=words.iterator();
		while(make.hasNext())
		{
			String word=make.next();
			songs.put(word, makeMap(names, word));
		}
	}
	public static void delete(TreeMap<String, HashSet<String>> songs)
	{
		String toDelete=JOptionPane.showInputDialog("delete?");
		Iterator<String> n=songs.keySet().iterator();
		HashSet<String> delete=new HashSet<String>();
		while(n.hasNext())
		{
			String s=n.next();
			Iterator<String> set=songs.get(s).iterator();
			while(set.hasNext())
			{
				String stuff=set.next();
				if(toDelete.equalsIgnoreCase(stuff))
					songs.get(s).remove(stuff);
			}
			if(songs.get(s).isEmpty())
				delete.add(s);
		}
		Iterator<String> deleted=delete.iterator();
		while(deleted.hasNext())
		{
			String s=deleted.next();
			songs.remove(s);
		}
	}
	public static void print(TreeMap<String, HashSet<String>> songs)
	{
		Iterator<String> n=songs.keySet().iterator();
		String print="";
		while(n.hasNext())
		{
			String s=n.next();
			print+=s+"="+songs.get(s)+"\n";
		}
		JOptionPane.showMessageDialog(null, print);
	}
	public static void main(String derp[])
	{
		changeJOP();
		TreeMap<String, HashSet<String>> songs=
			new TreeMap<String, HashSet<String>>();
		HashSet<String> words=new HashSet<String>();
		HashSet<String> names=new HashSet<String>();
		String fileName=JOptionPane.showInputDialog("File name:");
		fill(fileName, songs, words, names);
		checkKeys(songs);
		print(songs);
		int choice;
		String[] choices={"print", "delete", "add", "exit"};
		do{
			choice=JOptionPane.showOptionDialog
				(null, "Choose something: ", "Songs", 0,3,null, choices,0);
			switch(choice)
			{
			case 0: print(songs); break;
			case 1: delete(songs); break;
			case 2: add(songs, words, names);
					checkKeys(songs); break;
			}
		}while(choice!=3);
	}
}