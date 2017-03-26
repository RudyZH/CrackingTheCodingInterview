package 数组与字符串;

import java.util.Map;
import java.util.HashMap;

public class StringReduce {

	
	/*
	 * method myself
	 * 
	 */
	public String strReduce(String str) {
		if (str == null || str.length() <= 1)
			return str;
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length();) {
			int beginIdx = i;
			char c = str.charAt(beginIdx);
			int count = 1;
			while ((beginIdx+1) < str.length() && str.charAt(beginIdx+1) == c) {
				count++;
				beginIdx++;
			}
			sb.append(c);
			sb.append(count);
			
			if (beginIdx == i)
				i += 1;
			else 
				i = beginIdx + 1;
		}
		
		if (sb.length() >= str.length())
			return str;
		else 
			return new String(sb);
		
	}
	
	/*
	 *  method 2 
	 *  O(p+k^2)
	 *  bad
	 */
	
	public String compressBad(String str) {
		String myStr = "";
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last) {
				count ++;
			} else {
				myStr += last + "" + count;
				last = str.charAt(i);
				count = 1;
			}
		}
		return myStr + last + count;
	}
	
	/*
	 *  method 3
	 *  better
	 *  time O(n), space O(n)
	 */
	
	public String compressBetter(String str) {
		int size = countCompression(str);
		if (size >= str.length())
			return str;
		
		StringBuilder myStr = new StringBuilder();
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); ++i) {
			if (str.charAt(i) == last)
				count++;
			else {
				myStr.append(last);
				myStr.append(count);
				last = str.charAt(i);
				count = 1;
			} 
		}
		myStr.append(last);
		myStr.append(count);
		return myStr.toString();
	}
	
	private int countCompression(String str) {
		if (str == null || str.isEmpty())
			return 0;
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		for (int i = 1; i < str.length(); ++i) {
			if (str.charAt(i) == last)
				count++;
			else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}
	
	/*
	 *  method 4
	 *  not use StringBuilder
	 *  time O(n), space O(n)
	 */
	
	public String compressAlternate(String str) {
		int size = countCompression(str);
		if (size >= str.length())
			return str;
		
		char[] array = new char[size];
		int index = 0;
		char last = str.charAt(0);
		int count = 1;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == last)
				count ++;
			else {
				index = setChar(array, last, index, count);
				last = str.charAt(i);
				count = 1;
			}
		}
		index = setChar(array, last, index, count);
		return String.valueOf(array);
	}
	
	private int setChar(char[] array, char c, int index, int count) {
		array[index] = c;
		index ++;
		char[] cnt = String.valueOf(count).toCharArray();
		for (char x : cnt) {
			array[index] = x;
			index++;
		}
		return index;
	}
	
	
	public static void main(String[] args) {
		
		String s = "aabcccccaaa";
		StringReduce re = new StringReduce();
		System.out.println(re.strReduce(s));
		System.out.println(re.compressBetter(s));
		System.out.println(re.compressAlternate(s));
	}

}
