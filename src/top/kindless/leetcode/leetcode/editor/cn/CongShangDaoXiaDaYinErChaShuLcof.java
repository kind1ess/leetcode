//从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。 
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
// 返回： 
//
// [3,9,20,15,7]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数 <= 1000 
// 
// Related Topics 树 广度优先搜索 
// 👍 33 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import com.sun.jmx.snmp.SnmpNull;

import java.util.ArrayList;
import java.util.List;

public class CongShangDaoXiaDaYinErChaShuLcof {
    public static void main(String[] args) {
        Solution solution = new CongShangDaoXiaDaYinErChaShuLcof().new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        int[] ints = solution.levelOrder(root);
        for (int i : ints) {
            System.out.println(i);
        }
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
    public int[] levelOrder(TreeNode root) {
        if (root == null)
            return new int[0];
        MyQueue<TreeNode> myQueue = new MyQueue<>();
        myQueue.enQueue(root);
        List<Integer> list = new ArrayList<>();
        while (!myQueue.empty()){
            TreeNode treeNode = myQueue.deQueue();
            list.add(treeNode.val);
            myQueue.enQueue(treeNode.left);
            myQueue.enQueue(treeNode.right);
        }
        int size = list.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    class MyQueue<T>{
        private Node head,rear;

        private class Node{
            T val;
            Node next;
            public Node(T val,Node next){
                this.val = val;
                this.next = next;
            }
        }
        public void enQueue(T data){
            if (data == null){
                return;
            }
            if (empty()){
                head = new Node(data,null);
                rear = head;
            }else {
                rear.next = new Node(data,null);
                rear = rear.next;
            }
        }

        public T deQueue(){
            if (empty())
                return null;
            T t = head.val;
            head = head.next;
            return t;
        }

        public boolean empty(){
            return head==null;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
}