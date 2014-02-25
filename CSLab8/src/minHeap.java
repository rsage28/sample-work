import java.util.ArrayList;
/**
 * @author Richard
 * @date 21/11/13
 */
public class minHeap<T extends Comparable<T>>
{
	ArrayList<T> heapList;

	public minHeap()
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
		/**
		 * changed the sign on the compareTo
		 */
		while (index>0 && item.compareTo(parent)<0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}
	
	public T deleteMin()
	{
		/**
		 * flipped all signs
		 */
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
			int index, lIndex, rIndex, minIndex;
			T minChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;

			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the minChild and minIndex
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))<0)
					{
						minChild = heapList.get(lIndex);
						minIndex = lIndex;
					}
					else
					{
						minChild = heapList.get(rIndex);
						minIndex = rIndex;
					}

					//sift down if necesssary
					if (item.compareTo(minChild)>0)
					{
						heapList.set(minIndex, item);
						heapList.set(index, minChild);
						index = minIndex;
					}
					else found = true;
				}

				else if (lIndex < size()) //case 2: item to be sifted down has only left child
					//note: item to be sifted down cannot have only right child - it will violate the complete binary tree property
				{
					if (item.compareTo(heapList.get(lIndex))>0)
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

}