//给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。 
//
// 你应当保留两个分区中每个节点的初始相对位置。 
//
// 示例: 
//
// 输入: head = 1->4->3->2->5->2, x = 3
//输出: 1->2->2->4->3->5
// 
// Related Topics 链表 双指针 
// 👍 243 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class PartitionList {
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        MyQueue<ListNode> queue1 = new MyQueue<>();
        MyQueue<ListNode> queue2 = new MyQueue<>();
        ListNode p = head;
        while (p != null){
            if (p.val < x)
                queue1.enQueue(p);
            else queue2.enQueue(p);
            p = p.next;
        }
        ListNode ans = new ListNode(0);
        p = ans;
        while (!queue1.empty()){
            p.next = queue1.deQueue();
            p = p.next;
        }
        while (!queue2.empty()){
            p.next = queue2.deQueue();
            p = p.next;
        }
        p.next = null;
        return ans.next;
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

        public boolean empty(){
            return first == null;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}