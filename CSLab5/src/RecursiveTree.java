import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * @author Richard
 * @date 24/10/13
 */
public class RecursiveTree extends JApplet 
{
	/**
	 * auto inserted by eclipse to suppress an error
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * intizializes the applet
	 */
	public void init() 
	{
		setBackground(Color.white);
		setForeground(Color.white);
	}
	/**
	 * method to produce graphics
	 */
	public void paint(Graphics g) 
	{
		int toDraw = toDraw();
		Graphics2D g2 = (Graphics2D) g;
		g2.setPaint(Color.BLUE);
		tree(g2, 960, 0, toDraw);
	}
	/**
	 * @return how deep the tree is to go
	 */
	public int toDraw()
	{
		return Integer.parseInt(JOptionPane.showInputDialog("Input the number of trees to draw"));
	}
	/**
	 * @param g2 graphics to draw
	 * @param x x coordinate to start tree branches
	 * @param y y coordinate to start tree branches
	 * @param n depth of tree, decreases to limit the recursive method
	 * this method recursively draws the tree
	 */
	public void tree(Graphics2D g2, int x, int y, int n )
	{
		if(n==0)
			return;
		else
		{
			g2.drawLine(x, y, x-50, y+50);
			g2.drawLine(x, y, x+50, y+50);
			tree(g2, x-50, y+50, n-1);
			tree(g2, x+50, y+50, n-1);
		}
	}
	public static void main(String args[]) 
	{
		JFrame frame = new JFrame("Recursion");
		JApplet recursive = new RecursiveTree();
		/*this code was found at http://www.tutorialspoint.com/javaexamples/gui_line.htm
		 * it causes the window to close when the X is pressed
		*/ 
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//this code also comes from the website, sets up the window
		frame.getContentPane().add("Center", recursive);
		recursive.init();
		frame.pack();
		frame.setSize(new Dimension(1800, 900));
		frame.setVisible(true);
	}
}