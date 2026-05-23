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
        /*
        #########################################################################
        #                                                                       #
        #  =============================================                        #
        #                  SIDDARDHA CHILUVERU                                  #
        #  =============================================                        #
        #                                                                       #
        #  Author      : Siddardha Chiluveru                                    #
        #  Description : Solution / Code / Project                              #
        #  Date        : 2026-05-15                                             #
        #                                                                       #
        #########################################################################
        */
        Map<Integer, Integer> map = new HashMap<>();
        int pos = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        for (int i = 0; i < n; i++)
            map.put(inorder[i], i);      
        pos = n - 1;
        return build(inorder, postorder, 0, n - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder, int l, int r) {
        if (l > r)
            return null;      
        int rootval = postorder[pos];
        pos -= 1;
        TreeNode root = new TreeNode(rootval);
        int i = map.get(rootval);
        root.right = build(inorder, postorder, i + 1, r); // build right of it and then left
        root.left = build(inorder, postorder, l, i - 1);
        return root;
    }
}