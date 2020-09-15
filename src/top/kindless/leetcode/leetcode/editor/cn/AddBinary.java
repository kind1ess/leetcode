//给你两个二进制字符串，返回它们的和（用二进制表示）。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 输入: a = "11", b = "1"
//输出: "100" 
//
// 示例 2: 
//
// 输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
// Related Topics 数学 字符串 
// 👍 440 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class AddBinary {
    public static void main(String[] args) {
        Solution solution = new AddBinary().new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String addBinary(String a, String b) {
        if (a.length() < b.length()){
            String temp;
            temp = a;
            a = b;
            b = temp;
        }
        int i = a.length() - 1;
        int def = a.length() - b.length();
        int j = def;
        int carry = 0;
        String res = "";
        while (j > 0){
            b = "0" + b;
            j--;
        }
        while (i >= 0){
            char aChar = a.charAt(i);
            char bChar = b.charAt(i);
            int aNum = Character.getNumericValue(aChar);
            int bNum = Character.getNumericValue(bChar);
            int sum = aNum + bNum + carry;
            if (sum - 1 > 0){
                carry = 1;
            }
            else carry = 0;
            res = sum%2 + res;
            i--;
        }
        if (carry == 1)
            res = "1"+res;
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}