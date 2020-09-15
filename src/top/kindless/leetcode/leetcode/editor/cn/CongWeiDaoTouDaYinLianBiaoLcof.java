//输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。 
//
// 
//
// 示例 1： 
//
// 输入：head = [1,3,2]
//输出：[2,3,1] 
//
// 
//
// 限制： 
//
// 0 <= 链表长度 <= 10000 
// Related Topics 链表 
// 👍 47 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class CongWeiDaoTouDaYinLianBiaoLcof {
    public static void main(String[] args) {
        Solution solution = new CongWeiDaoTouDaYinLianBiaoLcof().new Solution();
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
    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null){
            node = node.next;
            length++;
        }
        int[] ans = new int[length];
        int i = length - 1;
        node = head;
        while (i >= 0){
            ans[i--] = node.val;
            node = node.next;
        }
//        reversePrint(head,ans,length-1);
        return ans;
    }
//    public void reversePrint(ListNode node,int[] ans,int index){
//        if (node == null)
//            return;
//        reversePrint(node.next,ans,index - 1);
//        ans[index] = node.val;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}