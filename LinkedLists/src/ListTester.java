import javax.swing.JOptionPane;
//Richard Sage
//period 7
public class ListTester
{
	public static void main(String[] args)
	{
		LLClass ll=new LLClass();
		
		String a=JOptionPane.showInputDialog("String 1");
		String b=JOptionPane.showInputDialog("String 2");
		String c=JOptionPane.showInputDialog("String 3");
		String d=JOptionPane.showInputDialog("String 4");
		String e=JOptionPane.showInputDialog("String 5");
		
		ll.addToEnd(a);
		ll.addToEnd(b);
		ll.addToEnd(c);
		ll.addToEnd(d);
		ll.addToEnd(e);
		
		JOptionPane.showMessageDialog(null, ll.toString());	
		ll.clear();
		JOptionPane.showMessageDialog(null, ll.toString());
		
		String f=JOptionPane.showInputDialog("String 1");
		String g=JOptionPane.showInputDialog("String 2");
		String h=JOptionPane.showInputDialog("String 3");
		String i=JOptionPane.showInputDialog("String 4");
		String j=JOptionPane.showInputDialog("String 5");
		
		ll.addToBeginning(f);
		ll.addToBeginning(g);
		ll.addToBeginning(h);
		ll.addToBeginning(i);
		ll.addToBeginning(j);
		
		JOptionPane.showMessageDialog(null, ll.toString());
		
		ll.clear();
		
		String k=JOptionPane.showInputDialog("String 1");
		String l=JOptionPane.showInputDialog("String 2");
		String m=JOptionPane.showInputDialog("String 3");
		String n=JOptionPane.showInputDialog("String 4");
		String o=JOptionPane.showInputDialog("String 5");
		
		ll.addInOrder(k);
		ll.addInOrder(l);
		ll.addInOrder(m);
		ll.addInOrder(n);
		ll.addInOrder(o);
		
		JOptionPane.showMessageDialog(null, ll.toString());
		
		String p=JOptionPane.showInputDialog("String 1");
		JOptionPane.showMessageDialog(null, ll.delete(p));
		JOptionPane.showMessageDialog(null, ll.toString());
		String q=JOptionPane.showInputDialog("String 2");
		JOptionPane.showMessageDialog(null, ll.delete(q));
		JOptionPane.showMessageDialog(null, ll.toString());
		String r=JOptionPane.showInputDialog("String 3");
		JOptionPane.showMessageDialog(null, ll.delete(r));
		JOptionPane.showMessageDialog(null, ll.toString());
		String s=JOptionPane.showInputDialog("String 4");
		JOptionPane.showMessageDialog(null, ll.delete(s));
		JOptionPane.showMessageDialog(null, ll.toString());
	}
}