//给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。 
//
// 示例 1: 
//
// 输入: 1->1->2
//输出: 1->2
// 
//
// 示例 2: 
//
// 输入: 1->1->2->3->3
//输出: 1->2->3 
// Related Topics 链表 
// 👍 358 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
        ListNode node = new ListNode(1);
        RemoveDuplicatesFromSortedListIi.insert(node,1);
        RemoveDuplicatesFromSortedListIi.insert(node,2);
        ListNode node1 = solution.deleteDuplicates(node);
        while (node1 != null){
            System.out.println(node1.val);
            node1 = node1.next;
        }
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
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode start = first;
        ListNode end = head;
        while (end != null && end.next != null){
            if (end.val == end.next.val){
                end = end.next;
                start.next = end;
            }
            else {
                end = end.next;
                start = start.next;
            }

        }
        return first.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}