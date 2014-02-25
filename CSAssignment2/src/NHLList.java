import java.util.*;
/**
 * @author Richard
 * @date 11/10/13
 */
public class NHLList
{
	/**
	 * attributes
	 */
	private List<PlayerRecord> playerList;
	private List<Team> teamList;
	/**
	 * constructor	
	 */
	public NHLList()
	{
		playerList = new List<PlayerRecord>();
		teamList = new List<Team>();
	}
	/**
	 * @param p player record to be added to the list
	 */
	public void add(PlayerRecord p)
	{
		playerList.add(p);
		if(!teamList.isEmpty()&&teamList.contains(new Team(p.getTeam(), p.getPenalties(), p.getWinningShots())))
		{
			Team curr = teamList.first();
			while(curr!=null)
			{
				if(curr.getName().equals(p.getTeam()))
				{
					curr.setPenaltyMins(curr.getPenaltyMins()+p.getPenalties());
					curr.setGWG(curr.getGWG()+p.getWinningShots());
				}
				curr = teamList.next();
			}
		}
		else teamList.add(new Team(p.getTeam(), p.getPenalties(), p.getWinningShots()));
	}
	/**
	 * @return whether the list is empty
	 */
	public boolean isEmpty()
	{
		return playerList.isEmpty();
	}
	/**
	 * @return the first player record
	 */
	public PlayerRecord getFirst()
	{
		return playerList.first();
	}
	/**
	 * @return the next player record
	 */
	public PlayerRecord getNext()
	{
		return playerList.next();
	}
	/**
	 * list all the player records
	 */
	public void enumerate()
	{
		playerList.enumerate();
	}
	/**
	 * sets the points for all players
	 */
	public void setPoints()
	{
		PlayerRecord curr = getFirst();
		while(curr!=null)
		{
			curr.setPoints(curr.getGoals()+curr.getAssists());
			curr = getNext();
		}
	}
	/**
	 * sets the points per game for all players
	 */
	public void setPpg()
	{
		PlayerRecord curr = getFirst();
		double points;
		double games;
		while(curr!=null)
		{
			games = curr.getGames();
			points = curr.getPoints();
			curr.setPpg(points/games);
			curr = getNext();
		}
	}
	/**
	 * sets the on goal percentage for all players
	 */
	public void setPct()
	{
		PlayerRecord curr = getFirst();
		double goals;
		double shots;
		while(curr!=null)
		{
			goals = curr.getGoals();
			shots = curr.getShots();
			curr.setPct((goals/shots)*100);
			curr = getNext();
		}
	}
	/**
	 * prints the player(s) with the highest points
	 */
	public void highestPoints()
	{
		int highest=-1;
		PlayerRecord curr = getFirst();
		while(curr!=null)
		{
			if(curr.getPoints()>highest)
				highest = curr.getPoints();
			curr = getNext();
		}
		curr = getFirst();
		ArrayList<PlayerRecord> highestPoints = new ArrayList<PlayerRecord>();
		while(curr!=null)
		{
			if(curr.getPoints()==highest)
				highestPoints.add(curr);
			curr = getNext();
		}
		System.out.println("Player(s) with the highest amount of points:");
		for(int i=0; i<highestPoints.size(); i++)
		{
			System.out.println("Player: "+highestPoints.get(i).getName()+", Points: "
					+highestPoints.get(i).getPoints()+", Team: "+highestPoints.get(i).getTeam());
		}
		System.out.println();
	}
	/**
	 * prints the player(s) with the most penalties
	 */
	public void mostAggressive()
	{
		int highest=-1;
		PlayerRecord curr = getFirst();
		while(curr!=null)
		{
			if(curr.getPenalties()>highest)
				highest = curr.getPenalties();
			curr = getNext();
		}
		curr = getFirst();
		ArrayList<PlayerRecord> highestPenalties = new ArrayList<PlayerRecord>();
		while(curr!=null)
		{
			if(curr.getPenalties()==highest)
				highestPenalties.add(curr);
			curr = getNext();
		}
		System.out.println("Most aggressive player(s):");
		for(int i=0; i<highestPenalties.size(); i++)
		{
			System.out.println("Player: "+highestPenalties.get(i).getName()+
					", Penalties: "+highestPenalties.get(i).getPenalties()+", Position: "+
					highestPenalties.get(i).getPos()+", Team: "+highestPenalties.get(i).getTeam());
		}
		System.out.println();
	}
	/**
	 * prints the player(s) with the most winning shots
	 */
	public void MVP()
	{
		int highest=-1;
		PlayerRecord curr = getFirst();
		while(curr!=null)
		{
			if(curr.getWinningShots()>highest)
				highest = curr.getWinningShots();
			curr = getNext();
		}
		curr = getFirst();
		ArrayList<PlayerRecord> highestWinningShots = new ArrayList<PlayerRecord>();
		while(curr!=null)
		{
			if(curr.getWinningShots()==highest)
				highestWinningShots.add(curr);
			curr = getNext();
		}
		System.out.println("Player(s) with the most winning shots:");
		for(int i=0; i<highestWinningShots.size(); i++)
		{
			System.out.println("Player: "+highestWinningShots.get(i).getName()+", Winning Shots: "
					+highestWinningShots.get(i).getWinningShots()+", Team: "+
					highestWinningShots.get(i).getTeam());
		}
		System.out.println();
	}
	/**
	 * prints the player(s) with the most shots on goal
	 */
	public void mostPromisingPlayer()
	{
		int highest=-1;
		PlayerRecord curr = getFirst();
		while(curr!=null)
		{
			if(curr.getShots()>highest)
				highest = curr.getShots();
			curr = getNext();
		}
		curr = getFirst();
		ArrayList<PlayerRecord> highestShots = new ArrayList<PlayerRecord>();
		while(curr!=null)
		{
			if(curr.getShots()==highest)
				highestShots.add(curr);
			curr = getNext();
		}
		System.out.println("Most promising player(s):");
		for(int i=0; i<highestShots.size(); i++)
		{
			System.out.println("Player: "+highestShots.get(i).getName()+", Shots: "
					+highestShots.get(i).getShots()+", Team: "+highestShots.get(i).getTeam());
		}
		System.out.println();
	}
	/**
	 * prints the team(s) with the highest penalty times
	 */
	public void mostPenatlyTeam()
	{
		int highest=-1;
		Team curr = teamList.first();
		while(curr!=null)
		{
			if(curr.getPenaltyMins()>highest)
				highest = curr.getPenaltyMins();
			curr = teamList.next();
		}
		curr = teamList.first();
		ArrayList<Team> highestPenalty = new ArrayList<Team>();
		while(curr!=null)
		{
			if(curr.getPenaltyMins()==highest)
				highestPenalty.add(curr);
			curr = teamList.next();
		}
		System.out.println("Team(s) with the most penatly times:");
		for(int i=0; i<highestPenalty.size(); i++)
		{
			System.out.println("Team: "
					+highestPenalty.get(i).getName()+", Penalties: "+
					highestPenalty.get(i).getPenaltyMins());
		}
		System.out.println();
	}
	/**
	 * prints the team(s) with the highest game winning goals
	 */
	public void mostGWG()
	{
		int highest=-1;
		Team curr = teamList.first();
		while(curr!=null)
		{
			if(curr.getGWG()>highest)
				highest = curr.getGWG();
			curr = teamList.next();
		}
		curr = teamList.first();
		ArrayList<Team> highestGWG = new ArrayList<Team>();
		while(curr!=null)
		{
			if(curr.getGWG()==highest)
				highestGWG.add(curr);
			curr = teamList.next();
		}
		System.out.println("Team(s) with the most game winning goals:");
		for(int i=0; i<highestGWG.size(); i++)
		{
			System.out.println("Team: "+highestGWG.get(i).getName()+
					", Game Winning Goals: "+highestGWG.get(i).getGWG());
		}
		System.out.println();
	}
	/**
	 * prints the team(s) with the highest game winning goals
	 */
	public void leastGWG()
	{
		int lowest=Integer.MAX_VALUE;
		Team curr = teamList.first();
		while(curr!=null)
		{
			if(curr.getGWG()<lowest)
				lowest = curr.getGWG();
			curr = teamList.next();
		}
		curr = teamList.first();
		ArrayList<Team> lowestGWG = new ArrayList<Team>();
		while(curr!=null)
		{
			if(curr.getGWG()==lowest)
				lowestGWG.add(curr);
			curr = teamList.next();
		}
		System.out.println("Team(s) with the lowest game winning goals:");
		for(int i=0; i<lowestGWG.size(); i++)
		{
			System.out.println("Team: "
					+lowestGWG.get(i).getName()+", Penalties: "+lowestGWG.get(i).getGWG());
		}
		System.out.println();
	}
}