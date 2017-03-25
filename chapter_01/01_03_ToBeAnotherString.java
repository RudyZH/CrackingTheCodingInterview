package 数组与字符串;

import java.util.Arrays;

public class ToBeAnotherString {

	
	/*
	 * method 1
	 * sort String
	 */
	public boolean toBeAnotherString1(String s1, String s2) {
		if (s1 == null || s1 == null || s1.length() != s2.length())
			return false;
		return sort(s1).equals(s2);
	}
	
	private String sort(String s) {
		char[] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}
	

	
	/*
	 * method 2
	 * hashMap
	 */
	
	public boolean toBeAnotherString2(String s1, String s2) {
		if (s1 == null || s1 == null || s1.length() != s2.length())
			return false;
		int[] map = new int[256];
		
		//该实现方法不如后面这种
//		for (int i = 0; i < s1.length(); i++) {
//			map[s1.charAt(i)]++;
//			map[s2.charAt(i)]--;
//		}
//		for (int i : map)
//			if (i != 0)
//				return false;
		
		for (int i = 0; i < s1.length(); i++)
			map[s1.charAt(i)]++;
		for (int i = 0; i < s2.length(); i++)
			if (--map[s2.charAt(i)] < 0)
				return false;
		return true;
	}
	
	public static void main(String[] args) {
		ToBeAnotherString t = new ToBeAnotherString();
		String s1 = "abcd";
		String s2 = "bdca";
		System.out.println(t.toBeAnotherString2(s1, s2));

	}

}
