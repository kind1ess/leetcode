//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1143 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.*;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /**
     * if(l1 == null) {
     *             return l2;
     *         }
     *         if(l2 == null) {
     *             return l1;
     *         }
     *
     *         if(l1.val < l2.val) {
     *             l1.next = mergeTwoLists(l1.next, l2);
     *             return l1;
     *         } else {
     *             l2.next = mergeTwoLists(l1, l2.next);
     *             return l2;
     *         }
     *
     * 作者：guanpengchn
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/hua-jie-suan-fa-21-he-bing-liang-ge-you-xu-lian-bi/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode lastOne = l1;
        while (lastOne.next != null){
            lastOne = lastOne.next;
        }
        lastOne.next = l2;
        sort(l1);
        return l1;
    }
    private void sort(ListNode listNode){
        ListNode next = listNode;
        List<Integer> list = new ArrayList<>();
        while (next != null){
            list.add(next.val);
            next = next.next;
        }
        Collections.sort(list);
        next = listNode;
        for (Integer integer : list) {
            next.val = integer;
            next = next.next;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}