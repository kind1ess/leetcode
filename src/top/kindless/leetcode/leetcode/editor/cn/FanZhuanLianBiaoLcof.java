//定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。 
//
// 
//
// 示例: 
//
// 输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL 
//
// 
//
// 限制： 
//
// 0 <= 节点个数 <= 5000 
//
// 
//
// 注意：本题与主站 206 题相同：https://leetcode-cn.com/problems/reverse-linked-list/ 
// Related Topics 链表 
// 👍 84 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.Stack;

public class FanZhuanLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new FanZhuanLianBiaoLcof().new Solution();
        ListNode listNode = new ListNode(1);
        ListNode p = listNode;
        p.next = new ListNode(2);
        p= p.next;
        p.next = new ListNode(3);
        p= p.next;
        p.next = new ListNode(4);
        p= p.next;
        p.next = new ListNode(5);
        ListNode node = solution.reverseList(listNode);
        while (node != null){
            System.out.println(node.val);
            node = node.next;
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
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null){
            stack.push(p);
            p = p.next;
        }
        ListNode res = new ListNode(0);
        ListNode r = res;
        while (!stack.empty()){
            r.next = stack.pop();
            r = r.next;
        }
        r.next = null;
        return res.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
}