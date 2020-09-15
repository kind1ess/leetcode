//二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉
//搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。 
//
// 返回转换后的单向链表的头节点。 
//
// 注意：本题相对原题稍作改动 
//
// 
//
// 示例： 
//
// 输入： [4,2,5,1,3,null,6,0]
//输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
// 
//
// 提示： 
//
// 
// 节点数量不会超过 100000。 
// 
// Related Topics 树 二叉搜索树 递归 
// 👍 36 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class BinodeLcci {
    public static void main(String[] args) {
        BinodeLcci binodeLcci = new BinodeLcci();
        Solution solution = binodeLcci.new Solution();
        TreeNode treeNode = binodeLcci.insert(null,4);
        treeNode = binodeLcci.insert(treeNode,2);
        treeNode = binodeLcci.insert(treeNode,5);
        treeNode = binodeLcci.insert(treeNode,1);
        treeNode = binodeLcci.insert(treeNode,3);
        treeNode = binodeLcci.insert(treeNode,6);
        treeNode = binodeLcci.insert(treeNode,0);
        treeNode = solution.convertBiNode(treeNode);
        while (treeNode != null){
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }
    public TreeNode insert(TreeNode node,int val){
        if (node == null)
            return new TreeNode(val);
        if (val > node.val){
            node.right = insert(node.right,val);
        }
        if (val < node.val){
            node.left = insert(node.left,val);
        }
        return node;
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
    public TreeNode convertBiNode(TreeNode root) {
        //todo
        TreeNode treeNode = new TreeNode(0);
        TreeNode p = treeNode;
        while (root != null){
            TreeNode[] treeNodes = deleteMin(root);
            root = treeNodes[1];
            p.right = treeNodes[0];
            p = p.right;
        }
        return treeNode.right;
    }
    private TreeNode[] deleteMin(TreeNode node){
        if (node.left == null){
            TreeNode[] treeNodes = new TreeNode[2];
            treeNodes[0] = node;
            treeNodes[1] = node.right;
            return treeNodes;
        }
        TreeNode[] treeNodes = deleteMin(node.left);
        node.left = treeNodes[1];
        treeNodes[1] = node;
        return treeNodes;
    }
//    private TreeNode[] leftMost(TreeNode node){
//        if (node == null)
//            return new TreeNode[2];
//        TreeNode[] treeNodes;
//        if (node.left != null) {
//            treeNodes = leftMost(node.left);
//            node.left = treeNodes[1];
//        }
//        else {
//            treeNodes = new TreeNode[2];
//            TreeNode t = node;
//            node = t.right;
//            treeNodes[0] = t;
//        }
//        treeNodes[1] = node;
//        return treeNodes;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
      int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}