import java.util.ArrayList;

public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heapList;

	public Heap()
	{
		heapList = new ArrayList<T>();
	}

	public int size()
	{
		return heapList.size();
	}

	public boolean isEmpty()
	{
		return heapList.isEmpty();
	}

	public void clear()
	{
		heapList.clear();
	}
	public void enumerate()
	{
		System.out.println(heapList);
	}

	public void add(T item)
	{
		heapList.add(item);

		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);

		while (index>0 && item.compareTo(parent)>0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}

	public T deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}

		else
		{
			T ret = heapList.get(0);	//get the item in the root. This is the largest item.

			T item = heapList.remove(heapList.size()-1);	//remove the last item.

			if (heapList.size()==0)
				return ret;						//if there was only one item in the heap to begin with, we are done.

			heapList.set(0, item);			//otherwise, proceed. Put the item in the root.
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;

			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the maxChild and maxIndex
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))>0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}

					//sift down if necesssary
					if (item.compareTo(maxChild)<0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else found = true;
				}

				else if (lIndex < size()) //case 2: item to be sifted down has only left child
					//note: item to be sifted down cannot have only right child - it will violate the complete binary tree property
				{
					if (item.compareTo(heapList.get(lIndex))<0)
					{
						heapList.set(index, heapList.get(lIndex));
						heapList.set(lIndex,item);

						index = lIndex;
					}

					else found = true;
				}
				//case 3: item to be sifted down has no children
				else found = true;

				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}

	}			
	/**
	 * @return min value in the heap
	 */
	public T findMin()
	{
		T min = heapList.get(heapList.size()-1);
		for(int i = heapList.size()-2; i > heapList.size()/2; i--)
		{
			if(min.compareTo(heapList.get(i))>0)
				min = heapList.get(i);
		}
		return min;
	}
	/**
	 * @param item item to search for
	 * @return index of the item in the heap
	 */
	public int findItem(T item)
	{
		int i = 0;
		while(i*2+2<heapList.size())
		{
			if(heapList.get(i).equals(item))
				return i;
			else if(heapList.get(i*2+1).equals(item))
				return i*2+1;
			else if(heapList.get(i*2+2).equals(item))
				return i*2+2;
			else i++;
		}
		if(heapList.get(i).equals(item))
			return i;
		else return -1;
	}
	/**
	 * @param item1 item to change
	 * @param item2 item for first item to be changed to
	 */
	public void changePriority(T item1, T item2)
	{
		int index;
		while(findItem(item1)>0)
		{
			index = findItem(item1);
			heapList.set(index, item2);
			if(index*2+1<heapList.size())
			{
				while(heapList.get(index).compareTo(heapList.get((index-1)/2))<0&&(heapList.get(index).compareTo(heapList.get((index*2+1)))>0)
						||heapList.get(index).compareTo(heapList.get((index*2+2)))>0)
				{
					if(heapList.get(index).compareTo(heapList.get((index-1)/2))<0)
					{
						T temp = heapList.get((index-1)/2);
						heapList.set((index-1)/2,heapList.get(index));
						heapList.set(index, temp);
					}
					else if(heapList.get(index).compareTo(heapList.get(index*2+1))<0)
					{
						T temp = heapList.get(index*2+1);
						heapList.set(index*2+1,heapList.get(index));
						heapList.set(index, temp);
					}
					else if(heapList.get(index).compareTo(heapList.get(index*2+2))<0)
					{
						T temp = heapList.get(index*2+2);
						heapList.set(index*2+2,heapList.get(index));
						heapList.set(index, temp);
					}
				}
			}
			else
			{
				while(heapList.get(index).compareTo(heapList.get((index-1)/2))<0)
				{
					if(heapList.get(index).compareTo(heapList.get((index-1)/2))<0)
					{
						T temp = heapList.get((index-1)/2);
						heapList.set((index-1)/2,heapList.get(index));
						heapList.set(index, temp);
					}
				}
			}
		}
	}
}