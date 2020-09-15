//给定一个二叉搜索树的根节点 root，返回树中任意两节点的差的最小值。 
//
// 
//
// 示例： 
//
// 输入: root = [4,2,6,1,3,null,null]
//输出: 1
//解释:
//注意，root是树节点对象(TreeNode object)，而不是数组。
//
//给定的树 [4,2,6,1,3,null,null] 可表示为下图:
//
//          4
//        /   \
//      2      6
//     / \    
//    1   3  
//
//最小的差值是 1, 它是节点1和节点2的差值, 也是节点3和节点2的差值。 
//
// 
//
// 注意： 
//
// 
// 二叉树的大小范围在 2 到 100。 
// 二叉树总是有效的，每个节点的值都是整数，且不重复。 
// 本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 
//相同 
// 
// Related Topics 树 递归 
// 👍 75 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class MinimumDistanceBetweenBstNodes {
    public static void main(String[] args) {
//        Solution solution = new MinimumDistanceBetweenBstNodes().new Solution();
        System.out.println(1 - Integer.MIN_VALUE);
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
    public int minDiffInBST(TreeNode root) {
        AtomicInteger ans = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger pre = new AtomicInteger(Integer.MAX_VALUE);
        AtomicInteger cur = new AtomicInteger();
        inorder(root,integer -> {
            cur.set(integer);
            int i = Math.abs(cur.get() - pre.get());
            if (i < ans.get())
                ans.set(i);
            pre.set(cur.get());
        });
        return ans.get();
    }
    private void inorder(TreeNode node,Consumer<? super Integer> action){
        if (node == null)
            return;
        inorder(node.left,action);
        action.accept(node.val);
        inorder(node.right,action);
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