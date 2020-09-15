//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。 
//
// 
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
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/ 
// Related Topics 树 递归 
// 👍 185 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class ZhongJianErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new ZhongJianErChaShuLcof().new Solution();
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
    private int[] preorder;
    private int[] inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null||inorder == null||preorder.length == 0||inorder.length == 0)
            return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return helper(0,preorder.length - 1,0,inorder.length - 1);
    }

    private TreeNode helper(int preStart,int preEnd,int inStart,int inEnd){
        if (preEnd < preStart || inEnd < inStart)
            return null;
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = indexOf(rootVal, inStart, inEnd);
        root.left = helper(preStart + 1,preStart + index - inStart,inStart,index - 1);
        root.right = helper(preStart + index - inStart + 1,preStart - inStart + inEnd,index + 1,inEnd);
        return root;
    }

    private int indexOf(int rootVal,int start,int end){
        int i = start;
        while (inorder[i] != rootVal && i <= end)
            i++;
        return i > end ? -1 : i;
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