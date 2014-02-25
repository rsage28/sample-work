public class PointTester
{
	public static void main(String[] args)
	{
		Point<Integer> point1 = new Point<Integer>(10,20);
		Point<Double> point2 = new Point<Double>(14.5, 15.6);
		Point<String> point3 = new Point<String>("topleftx",
				"toplefty");
		System.out.println(point1);
		System.out.println(point2);
		System.out.println(point3);
	}
}