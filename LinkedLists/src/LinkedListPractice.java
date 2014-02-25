import java.util.LinkedList;

//Richard Sage
//pd. 7
public class LinkedListPractice
{
	public static void fillLL(LinkedList ll)
	{
		ll.add("hamster");
		ll.addFirst("cat");
		ll.addFirst("bird");
		ll.add(2, "dog");
		ll.add("iguana");
		ll.add(3, "fish");
		ll.add(3, "ferret");
		ll.add("turtle");
	}
	public static void printElements(LinkedList ll)
	{
		System.out.println(ll.getFirst());
		System.out.println(ll.getLast());
		System.out.println(ll.get(3));
		System.out.println(ll.indexOf("fish"));
	}
	public static void removeElements(LinkedList ll)
	{
		ll.removeFirst();
		System.out.println(ll.toString());
		ll.removeLast();
		System.out.println(ll.toString());
		ll.remove(5);
		System.out.println(ll.toString());
	}
	public static void main(String args[])
	{
		System.out.println("Richard Sage");
		System.out.println("period 7");
		LinkedList ll=new LinkedList();
		fillLL(ll);
		System.out.println(ll.toString());
		System.out.println(ll.size());
		printElements(ll);
		removeElements(ll);
		ll.set(ll.lastIndexOf("dog"), "puppy");
		System.out.println(ll.toString());
		ll.clear();
		System.out.println(ll.toString());
	}	
}
/*
Richard Sage
period 7
[bird, cat, dog, ferret, fish, hamster, iguana, turtle]
8
bird
turtle
ferret
4
[cat, dog, ferret, fish, hamster, iguana, turtle]
[cat, dog, ferret, fish, hamster, iguana]
[cat, dog, ferret, fish, hamster]
[cat, puppy, ferret, fish, hamster]
[]
*/