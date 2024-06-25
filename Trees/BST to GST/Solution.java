/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {

        TreeNode temp = root;
        updateTree(temp);
        return root;
    }

    public void updateTree(TreeNode temp)
    {

        if (temp == null) {
            return;
        }

        updateTree(temp.right);
        sum += temp.val;
        temp.val = sum;
        updateTree(temp.left);
    }


}