//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
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
// Related Topics 树 广度优先搜索 
// 👍 576 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution solution = new BinaryTreeLevelOrderTraversal().new Solution();
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
        public Node(T data,Node next){
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
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}