package 递归与动态规划;

public class MagicIndex {

	
	/*  question 1
	 *  无重复值出现
	 */
	public int magicIdx(int[] nums) {
		return magicIdx(nums, 0, nums.length);	
	}
	
	private int magicIdx(int[] nums, int start, int end) {
		if (start > end || start < 0 || end > nums.length) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == mid)
			return mid;
		else if (nums[mid] > mid)
			return magicIdx(nums, start, mid - 1);
		else 
			return magicIdx(nums, mid + 1, end);	
	}
	
	/*
	 *  question 2
	 *  有重复值出现
	 */
	
	public int magicFast(int[] nums) {
		return magicFast(nums, 0, nums.length - 1);
	}
	
	public int magicFast(int[] nums, int start, int end) {
		if (end < start || start < 0 || end >= nums.length) 
			return -1;
		int midIdx = (start + end) / 2;
		int midVal = nums[midIdx];
		if (midIdx == midVal)
			return midIdx;
		
		int leftIdx = Math.min(midIdx - 1, midVal);
		int left = magicFast(nums, start, leftIdx);
		if (left >= 0) return left;
		
		int rightIdx = Math.max(midIdx + 1, midVal);
		int right = magicFast(nums, rightIdx, end);
		return right;
	}
	
	
	public static void main(String[] args) {
		MagicIndex m = new MagicIndex();
		int[] nums1 = {-1, 0, 1, 3, 7, 8, 9, 10, 11};
		int[] nums2 = {-1, -2, 0, 1, 2, 3, 4, 7, 12};
		int[] nums3 = {-1, -2, 0, 1, 4, 6, 7, 8, 9};
		int[] nums4 = {-10, -5, 2, 2, 2, 3, 4, 7, 9, 12, 13};
		System.out.println(m.magicIdx(nums1));
		System.out.println(m.magicIdx(nums2));
		System.out.println(m.magicIdx(nums3));
		System.out.println(m.magicFast(nums4));
	}
}
