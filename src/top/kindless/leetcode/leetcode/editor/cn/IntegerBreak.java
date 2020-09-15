//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。 
//
// 示例 1: 
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。 
//
// 示例 2: 
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。 
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。 
// Related Topics 数学 动态规划 
// 👍 331 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class IntegerBreak {
    public static void main(String[] args) {
        Solution solution = new IntegerBreak().new Solution();
        int n = 1;
        while (n<=58){
            System.out.print(solution.integerBreak(n++)+",");
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int integerBreak(int n) {
        int[] nums = {1,2,4,6,9,12,18,27,36,54,
                81,108,162,243,324,486,729,972,
                1458,2187,2916,4374,6561,8748,
                13122,19683,26244,39366,59049,
                78732,118098,177147,236196,354294,
                531441,708588,1062882,1594323,
                2125764,3188646,4782969,6377292,
                9565938,14348907,19131876,28697814,
                43046721,57395628,86093442,129140163,
                172186884,258280326,387420489,516560652,
                774840978,1162261467,1549681956};
        return nums[n-2];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}