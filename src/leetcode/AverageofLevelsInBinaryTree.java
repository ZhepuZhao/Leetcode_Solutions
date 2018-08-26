package leetcode;

import java.util.List;
import java.util.ArrayList;

public class AverageofLevelsInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.left = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.left = new TreeNode(0);
		System.out.println(averageOfLevels(root));
		ArrayList<Character> a = new ArrayList<Character>();
	}

	public static List<Double> averageOfLevels(TreeNode root) {
		List<Double> average = new ArrayList<Double>();
		List<Double> sum = new ArrayList<Double>();
		List<Integer> num = new ArrayList<Integer>();
//		sum.add((double) root.val);
//		num.add(1);
		traverse(root, 0, sum, num);
		for (int i = 0; i < sum.size(); i++) {
			average.add(sum.get(i)/num.get(i));
		}
		return average;
	}

    public static void traverse(TreeNode root, int level, List<Double> sum, List<Integer> num){
        if (root == null){
            return;
        }
        if (level > sum.size()-1){
            sum.add((double)root.val);
            num.add(1);
        } else{
            sum.set(level, sum.get(level)+root.val);
            num.set(level, num.get(level)+1);
        }
        level++;
        traverse(root.left, level, sum, num);
        traverse(root.right, level, sum, num);
        /*
        if (root.left != null){
            if (level > sum.size()-1){
                sum.add((double)root.left.val);
                num.add(1);
            } else{
                sum.set(level, sum.get(level)+root.left.val);
                num.set(level, num.get(level)+1);
            }
            traverse(root.left, level, sum, num);
        }
        if (root.right != null){
            if (level > sum.size()-1){
                sum.add((double)root.right.val);
                num.add(1);
            } else{
                sum.set(level, sum.get(level)+root.right.val);
                num.set(level, num.get(level)+1);
            }
            traverse(root.right, level, sum, num);
        }*/
    }

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
