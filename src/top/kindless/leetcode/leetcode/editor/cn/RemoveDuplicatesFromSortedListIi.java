//给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 示例 1: 
//
// 输入: 1->2->3->3->4->4->5
//输出: 1->2->5
// 
//
// 示例 2: 
//
// 输入: 1->1->1->2->3
//输出: 2->3 
// Related Topics 链表 
// 👍 327 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedListIi {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode head = new ListNode(1);
        RemoveDuplicatesFromSortedListIi ii = new RemoveDuplicatesFromSortedListIi();
        insert(head,2);
        insert(head,2);
        insert(head,3);
        insert(head,4);
        insert(head,4);
        insert(head,5);
        ListNode listNode = solution.deleteDuplicates(head);
        while (listNode != null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
    public static void insert(ListNode head,int val){
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode sentry = new ListNode(0);
        sentry.next = head;
        ListNode father = sentry;
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.val == current.next.val){
                int val = current.val;
                while(current !=null && current.val == val){
                    current = current.next;
                }
                father.next = current;
            }else{
                father = father.next;
                current = current.next;
            }
        }
        return sentry.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}