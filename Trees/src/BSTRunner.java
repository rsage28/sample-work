import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

public class BSTRunner
{
	public static void changeJOP()
	{
		UIManager.put("Label.font", new FontUIResource
				(new Font("Rockwell", Font.PLAIN, 20)));
		UIManager.put
			("OptionPane.messageForeground",new Color(0,0,205));
		UIManager.put("Panel.background",new Color(50,205,50));
		UIManager.put("OptionPane.background",new Color(0,0,205));
		UIManager.put("Button.background",new Color(255,215,0));
		UIManager.put("Button.foreground", new Color(255,20,147));
		UIManager.put("Button.font", new FontUIResource
				(new Font("Rockwell", Font.PLAIN, 18)));
	}
	public static void main(String[] args)
	{
		changeJOP();
		String phrase = JOptionPane.showInputDialog("Enter your phrase: ");
		BSTClass<String> t = new BSTClass<String>();

		TreePainter tp = new TreePainter();
		tp.setLocation(0,0);
		for (int i=0; i<phrase.length(); i++)
			t.add(phrase.substring(i, i+1));
		tp.setTree(t.getRoot());
		
		String character;
		String[] option={"Add","Delete","Print","Exit"};
		String[] option1={"Delete One","Delete All"};
		int choice, choice2, delete=-1;
		do{
			choice = JOptionPane.showOptionDialog(null,"What do you want to do?",
							"Choices",0,3,null,option,null);
			switch (choice)
			{
				case 0:	character = JOptionPane.showInputDialog("What character do you want to add?");
						t.add( character); break;
				case 1: choice2 = JOptionPane.showOptionDialog(null,"What do you want to do?",
						"Choices",0,3,null,option1,null);
						character=JOptionPane.showInputDialog("Enter a character to delete");
						if(choice2==0)
							delete=t.delete(character);					
						else delete=t.deleteAll(character);						
						if(delete==0)
							JOptionPane.showMessageDialog(null, "Nothing was deleted");
						else if(delete==1)
							JOptionPane.showMessageDialog(null, "1 character was deleted");
						else JOptionPane.showMessageDialog(null, delete+" characters were deleted"); break;
				case 2: JOptionPane.showMessageDialog(null, t.print()); break;
				case 3: System.exit(0);
			}			
			tp.setTree(t.getRoot());
		}while (choice != 4);
		tp.dispose();
	}	
}