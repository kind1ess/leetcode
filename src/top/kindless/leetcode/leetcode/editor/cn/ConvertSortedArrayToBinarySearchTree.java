//将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。 
//
// 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。 
//
// 示例: 
//
// 给定有序数组: [-10,-3,0,5,9],
//
//一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
//
//      0
//     / \
//   -3   9
//   /   /
// -10  5
// 
// Related Topics 树 深度优先搜索 
// 👍 532 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class ConvertSortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new ConvertSortedArrayToBinarySearchTree().new Solution();
        TreeNode treeNode = solution.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(treeNode);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int[] buf;
    public TreeNode sortedArrayToBST(int[] nums) {
        //todo
        buf = nums;
        return helper(0,nums.length - 1);
    }

    private TreeNode helper(int min,int max){
        if (min > max){
            return null;
        }
        int mid = (min + max)/2;
        TreeNode root = new TreeNode(buf[mid]);
        root.left = helper(min,mid - 1);
        root.right = helper(mid + 1,max);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
}