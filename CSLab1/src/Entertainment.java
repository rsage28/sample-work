//Tester (client) program: Entertainment
public class Entertainment
{
	public static void main(String[] args)
	{
		Film film = new Film("Titanic", "James Cameron", "James Cameron", 2245);
		Play play = new Play("Bus Stop", "Harold Clurman", "William Inge", 478);
		film.display();
		System.out.println();
		play.display();
	}
}
//Entertainment ends