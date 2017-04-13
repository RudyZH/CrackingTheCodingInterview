package 数学与概率;

public class GeneratePrimeNumSeq {

	public boolean[] sieveOfEratosthenes(int max) {
		boolean[] flags = new boolean[max + 1];
		
		init(flags);
		int prime = 2;
		
		while (prime <= max) {
			// 划掉余下为prime的倍数的数字
			crossOff(flags, prime);
			prime = getNextPrime(flags, prime);
			if (prime >= flags.length)
				break;
		}
		return flags;
	}
	
	private void crossOff(boolean[] flags, int prime) {
		//划掉余下为prime倍数的数字，可以从
		//prime*prime开始，因为如果k*prime
		//且k < prime，这个值早在之前的迭代中被
		//划掉了
		for (int i = prime * prime; i < flags.length; i += prime) 
			flags[i] = false;
	}
	
	private void init(boolean[] flags) {
		for (int i = 2; i < flags.length; i++)
			flags[i] = true;
	}
	
	private int getNextPrime(boolean[] flags, int prime) {
		int next = prime + 1;
		while (next < flags.length && !flags[next])
			next++;
		return next;
	}
	
	public static void main(String[] args) {
		GeneratePrimeNumSeq g = new GeneratePrimeNumSeq();
		int max = 90;
		boolean[] res = g.sieveOfEratosthenes(max);
		for (int i = 0; i < res.length; i++) {
			if (res[i] == true)
				System.out.println(i);
		}
	}
}
