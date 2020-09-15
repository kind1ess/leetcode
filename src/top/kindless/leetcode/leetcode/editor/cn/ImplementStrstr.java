//实现 strStr() 函数。 
//
// 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如
//果不存在，则返回 -1。 
//
// 示例 1: 
//
// 输入: haystack = "hello", needle = "ll"
//输出: 2
// 
//
// 示例 2: 
//
// 输入: haystack = "aaaaa", needle = "bba"
//输出: -1
// 
//
// 说明: 
//
// 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。 
//
// 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。 
// Related Topics 双指针 字符串 
// 👍 497 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class ImplementStrstr {
    public static void main(String[] args) {
        Solution solution = new ImplementStrstr().new Solution();
        System.out.println(solution.strStr("hello", "ll"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int strStr(String haystack, String needle) {
        int i = 0,j = 0;
        int[] next = new int[needle.length()];
        getNext(needle,next);
        while (i<haystack.length()&&j<needle.length()){
            if (j==0 || haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if (j == needle.length()){
            return i-needle.length();
        }
        return -1;
    }

    private void getNext(String needle,int[] next){
        if (next.length <= 1){
            return;
        }
        int i = 1,j = 0;
        next[0] = 0;
        while(i<next.length){
            if (j == 0 || needle.charAt(i) == needle.charAt(j)){
                next[i++] = j++;
            }else {
                j = next[j];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}