/**
 * @author Richard
 * @date 31/10/13
 */
public class OrderedListUtility
{
	/**
	 * @param first the first list to be merged
	 * @param second the second list to be merged
	 * @return the ordered list that is the merged list of first and second
	 */
	public static <T extends Comparable<T>> OrderedList<T> merge
	(OrderedList<T> first, OrderedList<T> second)
	{
		OrderedList<T> toReturn = new OrderedList<T>();
		int f1 = 0, f2 = 0;
		while(f1<first.size()&&f2<second.size())
		{
			if(first.get(f1).compareTo(second.get(f2))<0)
			{
				toReturn.add(toReturn.size()-1, first.get(f1));
				f1++;
			}
			else if(second.get(f2).compareTo(first.get(f1))<0)
			{
				toReturn.add(toReturn.size()-1, second.get(f2));
				f2++;
			}
			else{
				toReturn.add(toReturn.size()-1, first.get(f1));
				f1++;
				f2++;
			}
		}
		if(f1<first.size())
			for(int i = f1; i<first.size(); i++)
				toReturn.add(toReturn.size()-1, first.get(i));
		if(f2<second.size())
			for(int i = f2; i<second.size(); i++)
				toReturn.add(toReturn.size()-1, second.get(i));
		return toReturn;
	}
	/**
	 * @param first the first list to be intersected
	 * @param second the second list to be intersected
	 * @return the ordered list that is the intersection of first and second
	 */
	public static <T extends Comparable<T>> OrderedList<T>
	findIntersection (OrderedList<T> first, OrderedList<T> second)
	{
		OrderedList<T> toReturn = new OrderedList<T>();
		int f1 = 0, f2 = 0;
		while(f1<first.size()&&f2<second.size())
		{
			if(first.get(f1).compareTo(second.get(f2))<0)
				f1++;
			else if(second.get(f2).compareTo(first.get(f1))<0)
				f2++;
			else{
				toReturn.add(toReturn.size()-1, first.get(f1));
				f1++;
				f2++;
			}
		}
		return toReturn;
	}
	/**
	 * @param first the first list that will be subtracted from
	 * @param second the list to subtract all same names from first
	 * @return the ordered list of first - second (i.e. all names from first that are not also in second)
	 */
	public static <T extends Comparable<T>> OrderedList<T>
	findDifference (OrderedList<T> first, OrderedList<T> second)
	{
		OrderedList<T> toReturn = new OrderedList<T>();
		int f1 = 0, f2 = 0;
		while(f1<first.size()&&f2<second.size())
		{
			if(first.get(f1).compareTo(second.get(f2))<0)
			{
				toReturn.add(toReturn.size()-1, first.get(f1));
				f1++;
			}
			else if(second.get(f2).compareTo(first.get(f1))<0)
			{
				toReturn.add(toReturn.size()-1, second.get(f2));
				f2++;
			}
			else{
				f1++;
				f2++;
			}
		}
		return toReturn;
	}
}