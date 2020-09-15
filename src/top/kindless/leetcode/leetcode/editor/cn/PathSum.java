//给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。 
//
// 说明: 叶子节点是指没有子节点的节点。 
//
// 示例: 
//给定如下二叉树，以及目标和 sum = 22， 
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \      \
//        7    2      1
// 
//
// 返回 true, 因为存在目标和为 22 的根节点到叶子节点的路径 5->4->11->2。 
// Related Topics 树 深度优先搜索 
// 👍 408 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new PathSum().new Solution();
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
    public boolean hasPathSum(TreeNode root, int sum) {
//        List<Integer> list = new ArrayList<>();
//        sum(root,0,list);
//        return list.contains(sum);
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

//        作者：LeetCode-Solution
//        链接：https://leetcode-cn.com/problems/path-sum/solution/lu-jing-zong-he-by-leetcode-solution/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    }
    private void sum(TreeNode node, int sum, List<Integer> list){
        if (node == null)
            return;
        if (node.left == null && node.right == null){
            list.add(sum + node.val);
        }
        sum(node.left,sum + node.val,list);
        sum(node.right,sum + node.val,list);
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