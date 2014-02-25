/**
 * @author Richard
 * @date 01/10/13
 */
public class LotteryTest
{
	public static void main(String[] args)
	{
		StudentLottery lottery= new StudentLottery();
		lottery.addStudents();
		lottery.pickWinner();
	}
}