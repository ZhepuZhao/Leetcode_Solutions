package leetcode;

import java.util.*;

public class TwoSumInputAsABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TreeNode2 tree = new TreeNode2(5);
		// tree.left = new TreeNode2(3);
		// tree.right = new TreeNode2(6);
		// tree.left.left = new TreeNode2(2);
		// tree.left.right = new TreeNode2(4);
		// tree.right.right = new TreeNode2(7);
		TreeNode2 tree = new TreeNode2(2);
		tree.left = new TreeNode2(1);
		tree.right = new TreeNode2(3);
		findTarget(tree, 4);
	}

	public static boolean findTarget(TreeNode2 root, int k) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		traverse(root, arr);
		HashMap<Integer, Integer> tree_map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.size(); i++) {
			if (!tree_map.containsKey(arr.get(i))) {
				tree_map.put(arr.get(i), 1);
			} else {
				tree_map.replace(arr.get(i), tree_map.get(i) + 1);
			}

		}
		for (int i = 0; i < arr.size(); i++) {
			if (tree_map.containsKey(k - arr.get(i))) {
				if (k - arr.get(i) == arr.get(i)) {
					if (tree_map.get(arr.get(i)) > 1) {
						return true;
					}
				} else {
					return true;
				}
			}
		}
		return false;
	}

	public static void traverse(TreeNode2 root, ArrayList<Integer> arr) {
		if (root != null) {
			arr.add(root.val);
			traverse(root.left, arr);
			traverse(root.right, arr);
		} else {
			return;
		}

	}

}

class TreeNode2 {
	int val;
	TreeNode2 left;
	TreeNode2 right;

	TreeNode2(int x) {
		val = x;
	}
}