import java.io.*;
import java.util.*;
/**
 * @author Richard
 * @date 21/10/13
 */
public class ListDemo
{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner inFile = new Scanner(new File("nhlstats.txt"));
		String line;
		StringTokenizer token;
		String name;
		String pos;
		String team;
		int games;
		int goals;
		int assists;
		int penalties;
		int shots;
		int gwg;
		NHLList nhl = new NHLList();
		while(inFile.hasNext())
		{
			line = inFile.nextLine();
			token = new StringTokenizer(line, "\t");
			name = token.nextToken();
			pos = token.nextToken();
			team = token.nextToken();
			games = Integer.parseInt(token.nextToken());
			goals = Integer.parseInt(token.nextToken());
			assists = Integer.parseInt(token.nextToken());
			penalties = Integer.parseInt(token.nextToken());
			shots = Integer.parseInt(token.nextToken());
			gwg = Integer.parseInt(token.nextToken());
			nhl.add(new PlayerRecord(name, pos, team, games, goals, assists, penalties, shots, gwg));
		}
		inFile.close();
		nhl.setPct();
		nhl.setPoints();
		nhl.setPpg();
		System.out.println("Name\t\tPosition\tTeam\tGP\tG\tA\tPIM\tSOG\tGWG\tP\tPPG\tPCT");
		nhl.enumerate();
		System.out.println();
		nhl.highestPoints();
		nhl.mostAggressive();
		nhl.mostPromisingPlayer();
		nhl.MVP();
		nhl.mostGWG();
		nhl.mostPenatlyTeam();
		nhl.leastGWG();
	}
}