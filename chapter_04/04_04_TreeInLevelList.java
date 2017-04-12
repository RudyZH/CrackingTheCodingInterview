package 树与图;

import java.util.ArrayList;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left = null;
	TreeNode right = null;

	TreeNode(int x) {
		val = x;
	}
}

public class TreeInLevelList {

	/*
	 *  method 1
	 *  time  O(N)
	 *  space O(Log N)
      normal
	 */
	public void createLevelLinkedList(TreeNode root, 
			    ArrayList<LinkedList<TreeNode>> lists, int level) {
		if (root == null) return;
		LinkedList<TreeNode> list = null;
		if (lists.size() == level) {
			list = new LinkedList<TreeNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(root);
		createLevelLinkedList(root.left, lists, level + 1);
		createLevelLinkedList(root.right, lists, level + 1);
	}
	
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
		createLevelLinkedList(root, lists, 0);
		return lists;
	}
	
	
	/*
	 *  method 2
	 *  time  O(N)
	 *  space O(1)
      good
	 */
	public ArrayList<LinkedList<TreeNode>> createLevelLinkedList2(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
		LinkedList<TreeNode> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}
		
		while (current.size() > 0) {
			res.add(current);
			LinkedList<TreeNode> parents = current;
			current = new LinkedList<>();
			for (TreeNode parent : parents) {
				if (parent.left != null) 
					current.add(parent.left);
				if (parent.right != null)
					current.add(parent.right);
			}
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		TreeInLevelList t = new TreeInLevelList();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		
		ArrayList<LinkedList<TreeNode>> res = t.createLevelLinkedList(t1);
		for (LinkedList<TreeNode> l : res) {
			for (TreeNode node : l) 
				System.out.print(node.val + " ");
			System.out.println();
		}
		
		System.out.println();
		
		ArrayList<LinkedList<TreeNode>> res2 = t.createLevelLinkedList2(t1);
		for (LinkedList<TreeNode> l : res2) {
			for (TreeNode node : l) 
				System.out.print(node.val + " ");
			System.out.println();
		}
	}
}
