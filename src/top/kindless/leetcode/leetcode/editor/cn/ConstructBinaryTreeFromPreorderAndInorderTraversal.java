//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 629 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
    private int[] preorderBuf;
    private int[] inorderBuf;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderBuf = preorder;
        inorderBuf = inorder;
        return helper(0,preorder.length - 1,0,inorder.length - 1);
    }
    private TreeNode helper(int preStart,int preEnd,int inStart,int inEnd){
        if (preStart > preEnd || inStart > inEnd)
            return null;
        int val = preorderBuf[preStart];
        TreeNode node = new TreeNode(val);
        int i = indexOf(val, inorderBuf);
        node.left = helper(preStart + 1,preStart + i - inStart,inStart,i - 1);
        node.right = helper(
                preStart + i - inStart + 1,
                preEnd,
                i + 1,inEnd);
        return node;
    }

    private int indexOf(int num,int[] buf){
        for (int i = 0; i < buf.length; i++) {
            if (num == buf[i])
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
}