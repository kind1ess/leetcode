//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 135 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof {
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        System.out.println(solution.minArray(new int[]{3,1,3,3}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minArray(int[] numbers) {
        //todo
        if (numbers.length == 0)
            return -1;
        if (numbers.length == 1)
            return numbers[0];
        int lo = 0;
        int hi = numbers.length - 1;
        if (numbers[hi] > numbers[lo])
            return numbers[lo];
        while (hi != lo + 1){
            int mid = hi - (hi - lo) / 2;
            if (numbers[mid] < numbers[lo])
                hi = mid;
            else lo = mid;
        }
        return numbers[hi];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}