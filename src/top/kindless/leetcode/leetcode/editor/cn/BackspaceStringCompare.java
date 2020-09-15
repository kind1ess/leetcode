//给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。 
//
// 注意：如果对空文本输入退格字符，文本继续为空。 
//
// 
//
// 示例 1： 
//
// 输入：S = "ab#c", T = "ad#c"
//输出：true
//解释：S 和 T 都会变成 “ac”。
// 
//
// 示例 2： 
//
// 输入：S = "ab##", T = "c#d#"
//输出：true
//解释：S 和 T 都会变成 “”。
// 
//
// 示例 3： 
//
// 输入：S = "a##c", T = "#a#c"
//输出：true
//解释：S 和 T 都会变成 “c”。
// 
//
// 示例 4： 
//
// 输入：S = "a#c", T = "b"
//输出：false
//解释：S 会变成 “c”，但 T 仍然是 “b”。 
//
// 
//
// 提示： 
//
// 
// 1 <= S.length <= 200 
// 1 <= T.length <= 200 
// S 和 T 只含有小写字母以及字符 '#'。 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？ 
// 
//
// 
// Related Topics 栈 双指针 
// 👍 143 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution solution = new BackspaceStringCompare().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean backspaceCompare(String S, String T) {
        MyStack stack1 = new MyStack();
        MyStack stack2 = new MyStack();
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (c!='#')
                stack1.push(c);
            else stack1.pop();
        }
        for (int i = 0; i < T.length(); i++) {
            char c = T.charAt(i);
            if (c!='#')
                stack2.push(c);
            else stack2.pop();
        }
        return stack1.toString().equals(stack2.toString());
    }
}
class MyStack {
    private Node top;
    private int size;
    class Node{
        char data;
        Node next;
        public Node(char data,Node next){
            this.data = data;
            this.next = next;
        }
    }

    public void push(char data){
        top = new Node(data,top);
        size++;
    }

    public void pop(){
        if (top != null){
            top = top.next;
            size--;
        }
    }

    public char peek(){
        return top == null ? '\0' : top.data;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Node node = top;node != null;node = node.next){
            sb.append(node.data);
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}