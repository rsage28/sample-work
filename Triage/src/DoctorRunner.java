//Richard Sage
public class DoctorRunner
{
	public static void main(String[] args)
	{
		Doctor d1 = new Doctor();
		Doctor d2 = new Doctor("Winston", 0);
		Doctor d3 = new Doctor("Aidan", 1);
		Doctor d4 = new Doctor("Richard", 3);
		System.out.println("d1: "+d1);
		System.out.println("d2: "+d2);
		System.out.println("d3: "+d3);
		System.out.println("d4: "+d4);
		d1.setName("Paul");
		//d1.setTime(0, new Patient("Eric", new TriageCode("read")));
		System.out.println("new d1: "+d1);
		
		System.out.println("should be 3: "+d4.compareTo(d2));
		System.out.println("should be -1: "+d1.compareTo(d3));
		System.out.println("should be 0: "+d1.compareTo(d1));
		System.out.println("should be false: "+d3.equals(d2));
		System.out.println("should be true: "+d2.equals(d2));
	}
}
/*
p1: Name: , Time Available: 0
p2: Name: Winston, Time Available: 0
p3: Name: Aidan, Time Available: 1
p4: Name: Richard, Time Available: 3
new p1: Name: Paul, Time Available: 5
should be 3: 3
should be 4: 4
should be 0: 0
should be false: false
should be true: true
*/