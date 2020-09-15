//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 632 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import top.kindless.leetcode.leetcode.editor.cn.node.TreeNode;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static final PrintStream out = System.out;
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = solution.inorderTraversal(root);
        list.forEach(out::println);
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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode p = root;
        while (p != null){
            stack.push(p);
            p = p.left;
        }
        while (!stack.empty()){
            TreeNode pop = stack.pop();
            list.add(pop.val);
            TreeNode node = pop.right;
            while (node != null){
                stack.push(node);
                node = node.left;
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}