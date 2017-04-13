package 递归与动态规划;

public class CountWays {
	
	
	/*
	 *  method 1
	 *  递归
	 *  bad
	 */
	public int countWays1(int n) {
		if (n < 0) 
			return 0;
		else if (n == 0)
			return 1;
		else 
			return countWays1(n - 1) + countWays1(n - 2) + countWays1(n - 3);
	}
	
	/*
	 *  method 2
	 *  动态规划
	 *  good
	 */
	public int countWays2(int n) {
		if (n <= 0)
			return 0;
		int[] count = new int[n + 1];
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;
		for (int i = 3; i <= n; i++)
			count[i] = count[i - 1] + count[i - 2] + count[i - 3];
		return count[n];
	}
	
	public static void main(String[] args) {
		CountWays c = new CountWays();
		System.out.println(c.countWays2(30));

		System.out.println(c.countWays1(30));
		
	} 
}
