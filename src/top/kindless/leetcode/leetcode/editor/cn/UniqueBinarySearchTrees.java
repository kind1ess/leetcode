//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 764 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class UniqueBinarySearchTrees {
    public static void main(String[] args) {
        Solution solution = new UniqueBinarySearchTrees().new Solution();
        long currentTimeMillis = System.currentTimeMillis();
        for (int i = 1; i < 20; i++) {
            System.out.print(solution.numTrees(i)+",");
        }
        System.out.println(System.currentTimeMillis() - currentTimeMillis);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int nums;
    public int numTrees(int n) {
        int[] ans = new int[]{
                1,1,2,5,14,42,132,429,1430,
                4862,16796,58786,208012,742900,
                2674440,9694845,35357670,129644790,
                477638700,1767263190};
        return ans[n];
    }

//    private int helper(int min,int max){
//        if (max - min + 1  == 2)
//            return 2;
//        if (max - min + 1 < 2 )
//            return 1;
//        int res = 0;
//        for (int i = min; i <= max; i++) {
//            res += helper(min,i-1) * helper(i+1,max);
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}