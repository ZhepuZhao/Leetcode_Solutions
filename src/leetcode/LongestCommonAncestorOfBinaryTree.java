package leetcode;

import java.util.*;
public class LongestCommonAncestorOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(2);
		root.left.right.left = new TreeNode(7);
		root.left.right.right = new TreeNode(4);
		root.right.left = new TreeNode(0);
		root.right.right = new TreeNode(8);
		lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
	}
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        List<TreeNode> list1 = new ArrayList<TreeNode>();
        List<TreeNode> list2 = new ArrayList<TreeNode>();
        containTarget(root, p, list1);
        containTarget(root, q, list2);
        int i = list1.size()-1;
        int j = list2.size()-1;
        TreeNode result = null;
        while (true) {
            if (i < 0) {
                return list2.get(j+1);
            }
            if (j < 0) {
                return list1.get(i+1);
            }
            if (list1.get(i).val != list2.get(j).val) {
                result = list1.get(i+1);
            } else {
                i--;
                j--;
            }
        }
        
    }
    public static boolean containTarget(TreeNode root, TreeNode target, List<TreeNode> list) {
        if (root == null) return false;
        if (root.val == target.val) {
            list.add(root);
            return true;
        } else {
            if (containTarget(root.left, target, list) || containTarget(root.right, target, list)) {
                list.add(root);
                return true;
            }             
            return false;
        }
    }

}
