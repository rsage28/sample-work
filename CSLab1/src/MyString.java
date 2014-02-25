//class name
public class MyString
{
	//attributes
	private String word;
	//constructor
	public MyString(String w)
	{
		word=w;
	}
	//permute method that randomly swaps characters 2n times, where n is word length
	public String permute()
	{
		String mixed=word;
		char[] ch=mixed.toCharArray();
		for(int i=0; i<2*mixed.length(); i++)
		{
			int swap=(int)(Math.random()*(ch.length));
			int swap2=(int)(Math.random()*(ch.length));
			char temp=ch[swap];
			ch[swap]=ch[swap2];
			ch[swap2]=temp;
		}
		mixed=new String(ch);
		return mixed;
	}
	//to string method
	public String toString()
	{
		return word;
	}
}