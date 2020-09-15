//请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(
//1)。 示例： MinStack minStack = new MinStack(); minStack.push(-2); minStack.push(0);
// minStack.push(-3); minStack.getMin();   --> 返回 -3. minStack.pop(); minStack.top
//();      --> 返回 0. minStack.getMin();   --> 返回 -2. Related Topics 栈 
// 👍 23 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class MinStackLcci {
    public static void main(String[] args) {
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MinStack {

    /** initialize your data structure here. */
    private int min;
    private Node top;
    private class Node{
        int val;
        Node next;
        public Node(int val,Node next){
            this.val = val;
            this.next = next;
        }
    }
    public MinStack() {
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        top = new Node(x,top);
        if (x <= min)
            min = x;
    }
    
    public void pop() {
        if (top == null)
            return;
        top = top.next;
    }
    
    public int top() {
        if (top != null)
            return top.val;
        return -1;
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)

}