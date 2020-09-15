//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 40 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof {
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] exchange(int[] nums) {
//        int length = nums.length;
//        int[] ans = new int[length];
//        int i = 0;
//        int j = length - 1;
//        for (int num : nums) {
//            if ((num & 0x1) == 0)
//                ans[j--] = num;
//            else ans[i++] = num;
//        }
//        return ans;
        int i = 0,j = nums.length - 1;
        int tmp;
        while (i < j){
            while (i < j && (nums[i] & 0x1) != 0)
                i++;
            while (i < j && (nums[j] & 0x1) == 0)
                j--;
            if (i < j){
                tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}