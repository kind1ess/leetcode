//给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。 
//
// 如果不存在最后一个单词，请返回 0 。 
//
// 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。 
//
// 
//
// 示例: 
//
// 输入: "Hello World"
//输出: 5
// 
// Related Topics 字符串 
// 👍 225 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class LengthOfLastWord {
    public static void main(String[] args) {
        Solution solution = new LengthOfLastWord().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.isEmpty())
            return 0;
        int j = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                j = i;
            }
        }
        if (j == 0)
            return i;
        return i - j - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}