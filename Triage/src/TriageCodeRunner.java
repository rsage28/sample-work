//Richard Sage
public class TriageCodeRunner
{
	public static void main(String[] args)
	{
		TriageCode tc1 = new TriageCode();
		TriageCode tc2 = new TriageCode("red");
		TriageCode tc3 = new TriageCode("yellow");
		TriageCode tc4 = new TriageCode("green");
		System.out.println("tc1: "+tc1);
		System.out.println("tc2: "+tc2);
		System.out.println("tc3: "+tc3);
		System.out.println("tc4: "+tc4);
		tc1.setAll("black");
		System.out.println("new tc1: "+tc1);
//		this should cause an exception to be thrown
//			and the program to crash
//		tc3.setAll("pink");
		
		System.out.println("should be -2: "+tc2.compareTo(tc4));
		System.out.println("should be 1: "+tc4.compareTo(tc3));
		System.out.println("should be 0: "+tc1.compareTo(tc1));
		System.out.println("should be false: "+tc3.equals(tc2));
		System.out.println("should be true: "+tc2.equals(tc2));
	}
}
