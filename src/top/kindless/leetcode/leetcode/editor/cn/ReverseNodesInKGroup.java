//给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。 
//
// k 是一个正整数，它的值小于或等于链表的长度。 
//
// 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。 
//
// 
//
// 示例： 
//
// 给你这个链表：1->2->3->4->5 
//
// 当 k = 2 时，应当返回: 2->1->4->3->5 
//
// 当 k = 3 时，应当返回: 3->2->1->4->5 
//
// 
//
// 说明： 
//
// 
// 你的算法只能使用常数的额外空间。 
// 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。 
// 
// Related Topics 链表 
// 👍 657 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution solution = new ReverseNodesInKGroup().new Solution();
        ListNode listNode = new ListNode(1);
        ReverseNodesInKGroup kGroup = new ReverseNodesInKGroup();
        kGroup.insert(listNode,2);
        kGroup.insert(listNode,3);
        kGroup.insert(listNode,4);
        kGroup.insert(listNode,5);
        solution.reverseKGroup(listNode,2);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    private void insert(ListNode head, int val){
        if (head == null){
            head = new ListNode(val);
            return;
        }
        ListNode p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = new ListNode(val);
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
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = length(head);
        if (length <= k){
            return head;
        }
        ListNode start;
        ListNode end = head;
        int num = 0;
        while (length - num >= k){
            start = end;
            int i = 0;
            while (i < k){
                i++;
                num++;
                end = end.next;
                reverse(start,end,k);
            }
        }
        return head;
    }

    private int length(ListNode node){
        int length = 0;
        while (node != null){
            length++;
            node = node.next;
        }
        return length;
    }

    private void reverse(ListNode start, ListNode end,int k){
//        ListNode cur = node;
//        ListNode pre = null;
//        while (cur != null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//        return pre;
        ListNode next = end;
        ListNode cur = start;
        ListNode p;
        for (int i = 0; i < k; i++) {
            p = cur.next;
            cur.next = next;
            next = cur;
            cur = p;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
static class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
}