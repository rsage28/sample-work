import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
//Richard Sage
public class MapWorksheet
{
	public static void main(String derp[])
	{
		System.out.println("*HashMap output*");
		HashMap<String, String> things=new HashMap<String, String>();
		things.put("red", "rose");
		things.put("blue", "violet");
		things.put("yellow", "sunflower");
		things.put("white", "daisy");
		things.put("black", "lily");
		things.put("red", "tulip");
		things.put("blue", "blue bonnet");
		System.out.println(things.toString());
		things.put("pink", "rose");
		things.put("purple", "lily");
		System.out.println(things.toString());
		Iterator<String> stuff=things.keySet().iterator();
		while(stuff.hasNext())
		{
			String key=stuff.next();
			System.out.println(key+"="+things.get(key));
		}
		System.out.println(things.size());
		System.out.println(things.containsKey("red"));
		System.out.println(things.containsValue("rose"));
		System.out.println(things.get("red"));
		System.out.println(things.get("rose"));
		System.out.println();
		
		System.out.println("*TreeMap output*");
		TreeMap<String, String> places=new TreeMap<String, String>();
		places.put("red", "rose");
		places.put("blue", "violet");
		places.put("yellow", "sunflower");
		places.put("white", "daisy");
		places.put("black", "lily");
		places.put("red", "tulip");
		places.put("blue", "blue bonnet");
		System.out.println(places.toString());
		places.put("pink", "rose");
		places.put("purple", "lily");
		System.out.println(places.toString());
		Iterator<String> objects=places.keySet().iterator();
		while(objects.hasNext())
		{
			String key=objects.next();
			System.out.println(key+"="+places.get(key));
		}
		System.out.println(places.size());
		System.out.println(places.containsKey("red"));
		System.out.println(places.containsValue("rose"));
		System.out.println(places.get("red"));
		System.out.println(places.get("rose"));
	}
}
/*
*HashMap output*
{red=tulip, blue=blue bonnet, white=daisy, yellow=sunflower, black=lily}
{red=tulip, purple=lily, blue=blue bonnet, white=daisy, pink=rose, 
	yellow=sunflower, black=lily}
red=tulip
purple=lily
blue=blue bonnet
white=daisy
pink=rose
yellow=sunflower
black=lily
7
true
true
tulip
null

*TreeMap output*
{black=lily, blue=blue bonnet, red=tulip, white=daisy, yellow=sunflower}
{black=lily, blue=blue bonnet, pink=rose, purple=lily, red=tulip, 
	white=daisy, yellow=sunflower}
black=lily
blue=blue bonnet
pink=rose
purple=lily
red=tulip
white=daisy
yellow=sunflower
7
true
true
tulip
null
*/