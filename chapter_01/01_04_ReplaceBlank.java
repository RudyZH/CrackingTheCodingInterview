package 数组与字符串;

public class ReplaceBlank {

	/*
	 * method 1
	 * good
	 */
	public String repalceBlank(String str) {
		if (str == null || str.length() <= 0)
			return str;
		int originalLen = str.length();
		int numberOfBlank = 0;
		
		for(int i = 0; i < originalLen; i++) {
			if (str.charAt(i) == ' ')
				numberOfBlank++;
		}
		
		int newLen = originalLen + numberOfBlank * 2;
		char[] res = new char[newLen];
		
		int indexOfNew = newLen - 1;
		int indexOfOriginal = originalLen - 1;
		
		while (indexOfOriginal >= 0) {
			if (str.charAt(indexOfOriginal) == ' ') {
				res[indexOfNew--] = '0';
				res[indexOfNew--] = '2';
				res[indexOfNew--] = '%';
			} else {
				res[indexOfNew--] = str.charAt(indexOfOriginal);
			}
			--indexOfOriginal;
		}
		
		return new String(res);
	}
	
	/*
	 * method 2
	 * bad
	 */
	
	public void repalceSpaces(char[] str, int length) {
		int spaceCount = 0, newLength, i;
		for (i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaceCount++;
		}
		
		newLength = length + spaceCount * 2;
		str[newLength] = '\0';
		for (i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength -= 3;
			} else {
				str[newLength - 1] = str[i];
				newLength -= 1;
			}
		}
	}
	
	public static void main(String[] args) {
		
		char[] s = new char[10];
		s[0] = 'a';
		s[1] = ' ';
		s[2] = 'b';
		s[3] = ' ';
		s[4] = 'c';
		s[5] = ' ';
		ReplaceBlank r = new ReplaceBlank();
		r.repalceSpaces(s, 5);
		System.out.println(s);
		
	}

}
