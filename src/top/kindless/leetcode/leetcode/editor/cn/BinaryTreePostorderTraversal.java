//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 376 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreePostorderTraversal().new Solution();
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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        stack.push(root);
        while (!stack.empty()){
            TreeNode pop = stack.pop();
            res.push(pop.val);
            if (pop.left != null)
                stack.push(pop.left);
            if (pop.right != null)
                stack.push(pop.right);
        }
        return res;
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