package leetcode;

public class BSTInsertionIteratively {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(4);
		insertIntoBST(root,2);
		insertIntoBST(root,7);
//		insertIntoBST(root,1);
//		insertIntoBST(root,3);
		insertIntoBST(root,5);
		int a = 0;
	}
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        // recursively
        /*
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }        
        return root;*/
        
        // iteratively
        // we can always find a position to insert a node, so we just to find the position first and then insert it
        // if the cur is null, that means its parent is the node which the val should be rooted at.
        // So what we should do is to use prev to store the parent node 
        if (root == null) {
            root = new TreeNode(val);
        }
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.val < val) {
                prev = cur;
                cur = cur.right;
                
            } else {
                prev = cur;
                cur = cur.left;
            }
        }
        if (prev.val < val) {
            prev.right = new TreeNode(val);
        } else {
            prev.left = new TreeNode(val);
        }
        return root;


    }

}
