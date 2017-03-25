package 数组与字符串;

public class IsUniqueChar {

	/*
	 * method 1
	 * 暴力
	 */
	public boolean isUniqueChar(String s) {
		if (s == null || s.length() > 256)
			return false;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j))
					return false;
			}
		}
		return true;
	}
	
	/*
	 * method 2
	 * 使用额外存储空间
	 */
	public boolean isUniqueChar2(String s) {
		if (s == null || s.length() > 256)
			return false;
		boolean[] existed = new boolean[256];
		for (int i = 0; i < s.length(); ++i) {
			int val = s.charAt(i);
			if (existed[val])
				return false;
			existed[s.charAt(i)] = true;
		}
		return true;
	}
	
	/*
	 *  method 3 
	 *  假定字符串只有小写字母 a-z
	 *  使用位向量进一步优化存储空间
	 */
	public boolean isUniqueChar3(String s) {
		if (s == null || s.length() > 256)
			return false;
		int checker = 0;
		for (int i = 0; i < s.length(); i++) {
			int val = s.charAt(i) - 'a';
			if ((checker & (1 << val)) > 0)
				return false;
			checker |= (1 << val);
		}
		return true;
	}

	
	public static void main(String[] args) {
		String s = "abcdb";
		IsUniqueChar i = new IsUniqueChar();
		System.out.println(i.isUniqueChar3(s));

	}
}
