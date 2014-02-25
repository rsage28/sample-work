/**
 * @author Richard
 * @date 21/10/13
 */
public class Team
{
	/**
	 * attributes
	 */
	private String name;
	private int penaltyMins;
	private int GWG;
	/**
	 * constructor
	 */
	public Team(String n, int p, int g)
	{
		name = n;
		penaltyMins = p;
		GWG = g;
	}
	/**
	 * @return name of the team
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name name of the team
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return number of penalty minutes incurred by the team
	 */
	public int getPenaltyMins() {
		return penaltyMins;
	}
	/**
	 * @param penaltyMins number of penalty minutes to set
	 */
	public void setPenaltyMins(int penaltyMins) {
		this.penaltyMins = penaltyMins;
	}
	/**
	 * @return number of game winning goals made by the team
	 */
	public int getGWG() {
		return GWG;
	}
	/**
	 * @param gWG number of game winning goals to set
	 */
	public void setGWG(int gWG) {
		GWG = gWG;
	}
	/**
	 * @return string representation of data
	 */
	public String toString()
	{
		return "Name: "+name+", Penalties: "+penaltyMins+", Game winning goals: "+GWG;
	}
	/**
	 * @return whether the object equals this object
	 */
	public boolean equals(Object o)
	{
		return ((Team)o).getName().equals(name);
	}
}