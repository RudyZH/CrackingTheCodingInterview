package 递归与动态规划;
import java.util.ArrayList;

public class GetPerms {

	public ArrayList<String> getPerms(String str) {
		if (str == null) return null;
		ArrayList<String> permutation = new ArrayList<>();
		if (str.length() == 0) {
			permutation.add("");
			return permutation;
		}
		
		char first = str.charAt(0);
		String reminder = str.substring(1);
		ArrayList<String> words = getPerms(reminder);
		for (String word : words) {
			for (int j = 0; j <= word.length(); j++) {
				String s = insertCharAt(word, first, j);
				permutation.add(s);
			}
		}
		return permutation;
	}
	
	private String insertCharAt(String word, char c, int i) {
		String start = word.substring(0, i);
		String end = word.substring(i);
		return start + c + end;
	}
	
	
	public static void main(String[] args) {
		String s = "abcd";
		GetPerms g = new GetPerms();
		ArrayList<String> list = g.getPerms(s);
		for (String str : list)
			System.out.println(str);
	}

}
