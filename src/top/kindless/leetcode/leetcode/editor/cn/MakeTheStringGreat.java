//给你一个由大小写英文字母组成的字符串 s 。 
//
// 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i + 1] 不会同时满足下述条件： 
//
// 
// 0 <= i <= s.length - 2 
// s[i] 是小写字符，但 s[i + 1] 是相同的大写字符；反之亦然 。 
// 
//
// 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。 
//
// 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。 
//
// 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。 
//
// 
//
// 示例 1： 
//
// 输入：s = "leEeetcode"
//输出："leetcode"
//解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
// 
//
// 示例 2： 
//
// 输入：s = "abBAcC"
//输出：""
//解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
//"abBAcC" --> "aAcC" --> "cC" --> ""
//"abBAcC" --> "abBA" --> "aA" --> ""
// 
//
// 示例 3： 
//
// 输入：s = "s"
//输出："s"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 只包含小写和大写英文字母 
// 
// Related Topics 栈 字符串 
// 👍 5 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Stack;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        Solution solution = new MakeTheStringGreat().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
                continue;
            }
            Character peek = stack.peek();
            if (Math.abs(peek - c) == 32)
                stack.pop();
            else stack.push(c);
        }
        int size = stack.size();
        if (size == 0)
            return "";
        char[] chars = new char[size];
        for (int i = chars.length - 1; i >= 0; i--) {
            chars[i] = stack.pop();
        }
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}