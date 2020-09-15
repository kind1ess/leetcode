//一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 
//
// 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 
//
// 示例 1： 
//
// 输入：n = 2
//输出：2
// 
//
// 示例 2： 
//
// 输入：n = 7
//输出：21
// 
//
// 示例 3： 
//
// 输入：n = 0
//输出：1 
//
// 提示： 
//
// 
// 0 <= n <= 100 
// 
//
// 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/ 
//
// 
// Related Topics 递归 
// 👍 54 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class QingWaTiaoTaiJieWenTiLcof {
    public static void main(String[] args) {
        Solution solution = new QingWaTiaoTaiJieWenTiLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWays(int n) {
        if (n <= 1)
            return 1;
        if (n == 2)
            return 2;
        int num1 = 1;
        int num2 = 2;
        int num3 = 0;
        for (int i = 3; i <= n; i++) {
            num3 = (num1 + num2) % 1000000007;
            num1 = num2;
            num2 = num3;
        }
        return num3;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}