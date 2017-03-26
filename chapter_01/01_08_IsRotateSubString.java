package 数组与字符串;

public class IsRotateSubString {

	public boolean isRotateSubString(String s1, String s2) {
		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		StringBuilder sb = new StringBuilder();
		sb.append(s1).append(s1);
		
		return sb.toString().contains(s2);
	}
	
	public static void main(String[] args) {
		
		String s1 = "waterbottle";
		String s2 = "ottlewater";
		IsRotateSubString i = new IsRotateSubString();
		System.out.println(i.isRotateSubString(s1, s2));
	}

}
