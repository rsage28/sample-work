import java.io.*;
import java.util.*;

/**
 * @author Richard
 * @date 27/11/13
 */
public class Login
{
	public static void main(String[] args) 
	{
		//make the hash maps, read the file, and test the logins with methods
		HashMap<String, String> userPass = new HashMap<String, String>();
		HashMap<String, String> userName = new HashMap<String, String>();
		readFile(userPass, userName);
		login(userPass, userName);
	}
	/**
	 * @param userPass hash map containing the username and password combo
	 * @param userName hash map containing the username and full name combo
	 */
	public static void readFile(HashMap<String, String> userPass, HashMap<String, String> userName)
	{
		try {
			Scanner inFile = new Scanner(new File("logins.txt"));
			String line;
			String[] split;
			while(inFile.hasNext())
			{
				line = inFile.nextLine();
				split = line.split("\t");
				userPass.put(split[1], split[2]);
				userName.put(split[1], split[0]);
			}
			inFile.close();
		} catch (FileNotFoundException e){System.out.println("error: "+e);}
	}
	/**
	 * @param userPass hash map containing the username and password combo
	 * @param userName hash map containing the username and full name combo
	 */
	public static void login(HashMap<String, String> userPass, HashMap<String, String> userName)
	{
		//variables needed to test the login
		Scanner input = new Scanner(System.in);
		String username = "";
		String password;
		int numOfAttempts = 0;
		boolean correct = false;
		//loop for login attempts
		while(numOfAttempts < 3 && !correct)
		{
			numOfAttempts++;
			System.out.print("Login: ");
			username = input.nextLine();
			System.out.print("Password: ");
			password = input.nextLine();
			//if username is correct
			if(userPass.containsKey(username))
			{
				//if password is correct
				if(userPass.get(username).equals(password))
					correct = true;
				else System.out.println("Incorrect password. Please try again. You have "+(3-numOfAttempts)+" left");
			}
			else System.out.println("Incorrect username. Please try again. You have "+(3-numOfAttempts)+" left");
		}
		input.close();
		//successful login test
		if(correct)
		{
			String name = userName.get(username);
			System.out.println("Login successful. Welcome "+name);
		}
		else System.out.println("Sorry. Incorrect login. Please contact sysadmin.");
	}
}