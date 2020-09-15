//在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。 
//
// 示例: 
//
// s = "abaccdeff"
//返回 "b"
//
//s = "" 
//返回 " "
// 
//
// 
//
// 限制： 
//
// 0 <= s 的长度 <= 50000 
// Related Topics 哈希表 
// 👍 41 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class DiYiGeZhiChuXianYiCiDeZiFuLcof {
    public static void main(String[] args) {
        Solution solution = new DiYiGeZhiChuXianYiCiDeZiFuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.merge(c, 1, Integer::sum);
        }
        for (char c : chars) {
            if (map.get(c).equals(1))
                return c;
        }
        return ' ';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}