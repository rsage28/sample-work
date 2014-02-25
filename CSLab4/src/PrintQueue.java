import java.util.ArrayList;

/**
 * @author Richard
 * @date 21/10/13
 */
public class PrintQueue
{
	/**
	 * attribute
	 */
	private Queue<Job> jobs;
	/**
	 * constructor
	 */
	public PrintQueue()
	{
		jobs = new Queue<Job>();
	}
	public void lpr(String owner, int jobID)
	{
		jobs.enqueue(new Job(owner, jobID));
	}
	public void lpq()
	{
		if(!jobs.isEmpty())
		{
			System.out.println(jobs.first());
			for(int i=0; i<jobs.size()-1; i++)
				System.out.println(jobs.next());
		}
	}
	public void lprm(int job)
	{
		if(job == jobs.peek().getJobId())
			jobs.dequeue();
		else System.out.println("job not queued");
	}
	public void lprmAll(String owner)
	{
		ArrayList<Job> toRemove = new ArrayList<Job>();
		if(jobs.isEmpty())
			return;
		else if(jobs.size()==1)
		{
			if(jobs.peek().getOwner().equals(owner))
				jobs.clear();
			else System.out.println("Queue does not contain that Job");
		}
		else{
			Job curr=jobs.first();
			if(curr.getOwner().equals(owner))
				toRemove.add(curr);
			for(int i=0; i<jobs.size()-1; i++)
			{
				curr=jobs.next();
				if(curr.getOwner().equals(owner))
					toRemove.add(curr);
			}
		}
		for(int i=0; i<toRemove.size(); i++)
			jobs.remove(toRemove.get(i));
	}
}