//删除链表中等于给定值 val 的所有节点。 
//
// 示例: 
//
// 输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
// 
// Related Topics 链表 
// 👍 431 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class RemoveLinkedListElements {
    public static void main(String[] args) {
        Solution solution = new RemoveLinkedListElements().new Solution();
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node, q = node.next;
        while (q != null){
            if (q.val==val){
                q = q.next;
                p.next = q;
            }else {
                p = p.next;
                q = q.next;
            }
        }
        return node.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}