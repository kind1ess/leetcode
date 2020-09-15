//输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。 
//
// 示例1： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4 
//
// 限制： 
//
// 0 <= 链表长度 <= 1000 
//
// 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/ 
// Related Topics 分治算法 
// 👍 42 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class HeBingLiangGePaiXuDeLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new HeBingLiangGePaiXuDeLianBiaoLcof().new Solution();
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = new ListNode(0);
        ListNode res = r;
        while (p != null && q != null){
            if (p.val <= q.val){
                r.next = p;
                p = p.next;
            }else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        r.next = p == null ? q : p;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}