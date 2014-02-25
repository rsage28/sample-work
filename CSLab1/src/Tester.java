public class Tester
{
	public static void main(String[] args)
	{
		//create rectangle
		Rectangle2D r1=new Rectangle2D(2,2,5.5,4.9);
		//test area
		System.out.println("Area: "+r1.getArea());
		//test perimeter
		System.out.println("Perimeter: "+r1.getPerimeter());
		//test contains
		System.out.println("R1 contains point 3,3: "+r1.contains(3,3));
		System.out.println("R1 contains new rectangle: "+r1.contains(new Rectangle2D(4,5,10.5,3.2)));
		//test overlaps
		System.out.println("R1 overlaps with new rectangle: "+r1.overlaps(new Rectangle2D(3,4,2.3,5.4)));
	}
}