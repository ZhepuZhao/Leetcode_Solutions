package basicDataStructure;

import java.util.*;
public class BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) return list;
		queue.offer(root);
		while (!queue.isEmpty()) {
			List<Integer> temp = new ArrayList<Integer>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = queue.poll();
				temp.add(cur.val);
				if (cur.left == null) queue.offer(cur.left);
				if (cur.right == null) queue.offer(cur.right);
			}
			list.add(temp);
		}
		return list;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode (int val) {
		this.val = val;
	}
}
