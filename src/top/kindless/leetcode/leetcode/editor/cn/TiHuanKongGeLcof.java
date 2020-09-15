//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 
//
// 
//
// 示例 1： 
//
// 输入：s = "We are happy."
//输出："We%20are%20happy." 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 10000 
// 👍 35 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class TiHuanKongGeLcof {
    public static void main(String[] args) {
        Solution solution = new TiHuanKongGeLcof().new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        int oldLength = s.length();
        int spaceNum = 0;
        char[] oldChars = s.toCharArray();
        for (char c : oldChars) {
            if (c == ' ')
                spaceNum++;
        }
        int newLength = oldLength + spaceNum * 2;
        char[] newChars = new char[newLength];
        int i = newLength - 1;
        int j = oldLength - 1;
        while (i >= 0 && j >= 0){
            if (oldChars[j] == ' '){
                newChars[i--] = '0';
                newChars[i--] = '2';
                newChars[i--] = '%';
                j--;
            }else {
                newChars[i--] = oldChars[j--];
            }
        }
        return new String(newChars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}