package 位操作;

public class UpdateBits {

	public int updateBits(int n, int m, int i, int j) {
		int allOnes = ~0;
		int left = allOnes << (j + 1);;
		int right = ((1 << i) - 1);
		int mask = left | right;
		int n_cleared = n & mask;
		int m_shifted = m << i;
		return n_cleared | m_shifted;
	}
	
	public static void main(String[] args) {
		UpdateBits u = new UpdateBits();
		int m = 0B10011;
		int n = 0B10000000000;
		
		System.out.println(Integer.toBinaryString(u.updateBits(n, m, 2, 6)));
	}
}
