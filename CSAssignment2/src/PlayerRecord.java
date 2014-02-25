/**
 * @author Richard
 * @date 11/10/13
 */
public class PlayerRecord
{
	/**
	 * attributes
	 */
	private String name;
	private String pos;
	private String team;
	private int games;
	private int goals;
	private int assists;
	private int penalties;
	private int shots;
	private int winningShots;
	private int points;
	private double ppg;
	private double pct;
	/**
	 * constructors
	 */
	public PlayerRecord()
	{
		name = "";
		pos = "";
		team = "";
		games = 0;
		goals = 0;
		assists = 0;
		penalties = 0;
		shots = 0;
		winningShots = 0;
	}
	public PlayerRecord(String n, String po, String t, int ga, int go, int a, int pe, int s, int w)
	{
		name = n;
		pos = po;
		team = t;
		games = ga;
		goals = go;
		assists = a;
		penalties = pe;
		shots = s;
		winningShots = w;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPos() {
		return pos;
	}
	public void setPos(String pos) {
		this.pos = pos;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public int getGames() {
		return games;
	}
	public void setGames(int games) {
		this.games = games;
	}
	public int getGoals() {
		return goals;
	}
	public void setGoals(int goals) {
		this.goals = goals;
	}
	public int getAssists() {
		return assists;
	}
	public void setAssists(int assists) {
		this.assists = assists;
	}
	public int getPenalties() {
		return penalties;
	}
	public void setPenalties(int penalties) {
		this.penalties = penalties;
	}
	public int getShots() {
		return shots;
	}
	public void setShots(int shots) {
		this.shots = shots;
	}
	public int getWinningShots() {
		return winningShots;
	}
	public void setWinningShots(int winningShots) {
		this.winningShots = winningShots;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public double getPpg() {
		return ppg;
	}
	public void setPpg(double ppg) {
		this.ppg = ppg;
	}
	public double getPct() {
		return pct;
	}
	public void setPct(double pct) {
		this.pct = pct;
	}
	public String toString() {
		if(name.length()<=7)
		{
			if(pos.length()==1)
				return name+"\t\t"+pos+"\t\t"+team+"\t"+games+"\t"+goals+"\t"+assists+"\t"+
					penalties+"\t"+shots+"\t"+winningShots+"\t"+points+"\t"+ppg+"\t"+pct;
			else return name+"\t\t"+pos+"\t\t"+team+"\t"+games+"\t"+goals+"\t"+assists+"\t"+
				penalties+"\t"+shots+"\t"+winningShots+"\t"+points+"\t"+ppg+"\t"+pct;
		}
		else
		{
			if(pos.length()==1)
				return name+"\t"+pos+"\t\t"+team+"\t"+games+"\t"+goals+"\t"+assists+"\t"+
					penalties+"\t"+shots+"\t"+winningShots+"\t"+points+"\t"+ppg+"\t"+pct;
			else return name+"\t"+pos+"\t\t"+team+"\t"+games+"\t"+goals+"\t"+assists+"\t"+
				penalties+"\t"+shots+"\t"+winningShots+"\t"+points+"\t"+ppg+"\t"+pct;
		}		
	}
}