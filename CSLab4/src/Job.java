/**
 * @author Richard
 * @date 21/10/13
 */
public class Job
{
	/**
	 * attributes
	 */
	private String owner;
	private int jobId;
	/**
	 * @param o owner
	 * @param j job ID
	 */
	public Job(String o, int j)
	{
		owner = o;
		jobId = j;
	}
	/**
	 * @return owner
	 */
	public String getOwner()
	{
		return owner;
	}
	/**
	 * @return job ID
	 */
	public int getJobId()
	{
		return jobId;
	}
	/**
	 * @return to string for the class
	 */
	public String toString()
	{
		return owner+"\t"+jobId;
	}
	/**
	 * @return whether the two Jobs are equal
	 * @param j the Job to be compared
	 */
	public boolean equals(Job j)
	{
		return j.getOwner().equals(owner);
	}
}