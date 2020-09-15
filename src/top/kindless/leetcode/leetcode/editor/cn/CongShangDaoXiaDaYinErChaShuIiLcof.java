//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。 
//
// 
//
// 例如: 
//给定二叉树: [3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/ 
// Related Topics 树 广度优先搜索 
// 👍 42 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import top.kindless.leetcode.leetcode.editor.cn.node.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuIiLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuIiLcof().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        MyQueue<TreeNode> myQueue = new MyQueue<>();
        myQueue.enQueue(root);
        TreeNode last = root;
        TreeNode nLast = last;
        List<Integer> list = new ArrayList<>();
        while (myQueue.size()>0){
            TreeNode treeNode = myQueue.deQueue();
            last = treeNode;
            list.add(treeNode.val);
            myQueue.enQueue(treeNode.left);
            myQueue.enQueue(treeNode.right);
            if (last == nLast){
                res.add(list);
                list = new ArrayList<>();
                nLast = myQueue.rear();
            }
        }
        return res;
    }
}
    class MyQueue<T>{

        private Node first;
        private Node rear;
        private int size;

        private class Node{
            T data;
            Node next;
            public Node(T data, Node next){
                this.data = data;
                this.next = next;
            }
        }
        public void enQueue(T data){
            if (data == null)
                return;
            if (first == null){
                first = new Node(data,null);
                rear = first;
            }
            else {
                rear.next = new Node(data,null);
                rear = rear.next;
            }
            size++;
        }

        public T deQueue(){
            T data = null;
            if (first != null) {
                data = first.data;
                first = first.next;
                size--;
            }
            return data;
        }

        public int size(){
            return size;
        }

        public T rear(){
            return rear.data;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}