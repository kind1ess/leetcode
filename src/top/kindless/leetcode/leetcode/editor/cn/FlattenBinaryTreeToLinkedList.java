//给定一个二叉树，原地将它展开为一个单链表。 
//
// 
//
// 例如，给定二叉树 
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6 
//
// 将其展开为： 
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6 
// Related Topics 树 深度优先搜索 
// 👍 467 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class FlattenBinaryTreeToLinkedList {
    public static void main(String[] args) {
        Solution solution = new FlattenBinaryTreeToLinkedList().new Solution();
        TreeNode root = new TreeNode(1,null,null);
        root.left = new TreeNode(2,new TreeNode(3,null,null),new TreeNode(4,null,null));
        root.right = new TreeNode(5,null,new TreeNode(6,null,null));
        solution.flatten(root);
        long nanoTime = System.currentTimeMillis();
        while (root != null){
            System.out.println(root.val);
            root = root.right;
        }
        System.out.println("耗时："+(System.currentTimeMillis() - nanoTime)+"毫秒");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public void flatten(TreeNode root) {
        getAnswer(root);
    }

    private TreeNode getAnswer(TreeNode node){
        if (node == null)
            return null;
        if (node.right == null&&node.left == null)
            return node;
        if (node.left == null){
            node.right = getAnswer(node.right);
            return node;
        }
        TreeNode tmp = getAnswer(node.right);
        node.right = getAnswer(node.left);
        node.left = null;
        TreeNode rightMost = rightMost(node.right);
        rightMost.right = tmp;
        return node;
    }
    private TreeNode rightMost(TreeNode node){
        if (node == null || node.right == null)
            return node;
        while (node.right != null)
            node = node.right;
        return node;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }
}
}