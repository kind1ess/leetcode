//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 368 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIiInputArrayIsSorted {
    public static void main(String[] args) {
        Solution solution = new TwoSumIiInputArrayIsSorted().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int length = numbers.length;
            int[] res = new int[2];
            for(int i = 0;i < length-1; i++){
                int a = numbers[i];
                int b = target - a;
                int index2 = binarySearch(numbers,b,i+1,length-1);
                if(index2 != -1){
                    res[0] = i+1;
                    res[1] = index2+1;
                    break;
                }
            }
            return res;
        }
        private int binarySearch(int[] numbers,int x,int lo,int hi){
            while(lo <= hi){
                int mid = (lo + hi)/2;
                if (numbers[mid] == x){
                    return mid;
                }
                else if(numbers[mid] < x){
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
            return -1;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}