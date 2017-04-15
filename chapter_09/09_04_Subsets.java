https://github.com/RudyZH/LeetCodeSolutionsInJavaAndCpp/blob/master/Java/078_Subsets.java

package 递归与动态规划;
import java.util.ArrayList;


// 见 LeetCode 78题
public class Subsets {

	public ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allSubsets;
		if (set.size() == index) {
			allSubsets = new ArrayList<ArrayList<Integer>>();
			allSubsets.add(new ArrayList<Integer>());
		} else {
			allSubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
			for (ArrayList<Integer> subset : allSubsets) {
				ArrayList<Integer> newSubset = new ArrayList<>();
				newSubset.addAll(subset);
				newSubset.add(item);
				moresubsets.add(newSubset);
			}
			allSubsets.addAll(moresubsets);
		}
		return allSubsets;
	}
	
	/*
	 *  method 2
	 *  组合数学
	 */
	
	public ArrayList<ArrayList<Integer>> getSubsets2(ArrayList<Integer> set) {
		ArrayList<ArrayList<Integer>> allSubsets = new ArrayList<>();
		int max = 1 << set.size();
		for (int k = 0; k < max; k++) {
			ArrayList<Integer> subset = convertIntToSet(k, set);
			allSubsets.add(subset);
		}
		return allSubsets;
	}
	
	private ArrayList<Integer> convertIntToSet(int x, ArrayList<Integer> set) {
		ArrayList<Integer> subset = new ArrayList<>();
		int index = 0;
		for (int k = x; k > 0; k >>= 1) {
			if ((k & 1) == 1)
				subset.add(set.get(index));
			index++;
		}
		return subset;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(1);
		nums.add(2);
		nums.add(3);
		nums.add(4);
		
		Subsets s = new Subsets();
		ArrayList<ArrayList<Integer>> res = s.getSubsets2(nums);
		for (ArrayList<Integer> list : res) {
			for(int e : list)
				System.out.print(e + " ");
			System.out.println();
		}
	}
}
