import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
//Richard Sage
public class Triage
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
				(new Font("Poor Richard", Font.PLAIN, 14)));
	}
	public static void fillAmballance(Stack<Patient> ambalance)
	{
		int time=0;
		try{
			Scanner inFile=new Scanner(new File(
					JOptionPane.showInputDialog
					("What file for patients?")));
			while(inFile.hasNext())
			{
				Patient p1=new Patient(inFile.nextLine(),new TriageCode(inFile.nextLine()),time);
				ambalance.push(p1);
				time++;
			}
		}catch(Exception e){System.out.println("error: "+e);}
	}
	public static void emptyAmballance(Stack<Patient> ambalance, 
			Stack<Patient> stackODeadPeople, 
			PriorityQueue<Patient> waitingRoom)
	{
		while(!ambalance.empty())
		{
			if(ambalance.peek().getTc().getNum()>0)
				waitingRoom.add(ambalance.pop());
			else stackODeadPeople.push(ambalance.pop());
		}
	}
	public static void treatinPatientsYo(PriorityQueue<Doctor> docs,
			PriorityQueue<Patient> waitingRoom)
	{
		int time=0;
		try{
			Scanner inFile=new Scanner(new File(
					JOptionPane.showInputDialog
					("What file for doctors?")));
			while(inFile.hasNext())
			{
				Doctor d1=new Doctor(inFile.nextLine(),time);
				docs.add(d1);
				time++;
			}
		}catch(Exception e){System.out.println("error: "+e);}		
		String shtuff="";
		int time1=0;
		if(!docs.isEmpty())
		{
			while(!waitingRoom.isEmpty())
			{
				time1++;
				if(docs.peek().gettimeAvailable()<=time1)
				{
					Doctor d=docs.remove();
					d.setTime(time1, waitingRoom.peek());
					shtuff+="Time period "+ time1+": "+d+" is helping "+
					waitingRoom.remove()+"\n";			
					docs.add(d);
				}
				else shtuff+="Time period "+time1+
				": no doctor available"+"\n";
			}
		}
		else JOptionPane.showMessageDialog(null,"No doctors on call");
		JOptionPane.showMessageDialog(null, shtuff);
	}
	public static void tripToTehMorgue(Stack<Patient> stackODeadPeople)
	{
		String shtuff="";
		while(!stackODeadPeople.isEmpty())
			shtuff+=stackODeadPeople.pop()+"\n";
		JOptionPane.showMessageDialog(null, shtuff);
	}
	public static void main(String derp[])
	{
		changeJOP();
		Stack<Patient> ambalance=new Stack<Patient>();
		JOptionPane.showMessageDialog
			(null, "The ambulance is being loaded...");
		fillAmballance(ambalance);
		Stack<Patient> stackODeadPeople=new Stack<Patient>();
		PriorityQueue<Patient> waitingRoom=new PriorityQueue<Patient>();
		JOptionPane.showMessageDialog
			(null, "The ambulance is being unloaded...");
		emptyAmballance(ambalance, stackODeadPeople, waitingRoom);
		PriorityQueue<Doctor> doctors=new PriorityQueue<Doctor>();
		JOptionPane.showMessageDialog
			(null, "Doctors are treating patients...");
		treatinPatientsYo(doctors, waitingRoom);
		JOptionPane.showMessageDialog
			(null, "The trip to the morgue...");
		tripToTehMorgue(stackODeadPeople);
	}
}