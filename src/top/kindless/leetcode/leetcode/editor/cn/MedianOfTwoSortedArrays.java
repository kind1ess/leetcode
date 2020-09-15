//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。 
//
// 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。 
//
// 你可以假设 nums1 和 nums2 不会同时为空。 
//
// 
//
// 示例 1: 
//
// nums1 = [1, 3]
//nums2 = [2]
//
//则中位数是 2.0
// 
//
// 示例 2: 
//
// nums1 = [1, 2]
//nums2 = [3, 4]
//
//则中位数是 (2 + 3)/2 = 2.5
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 2975 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        int[] nums1 = {1,3,5,7};
        int[] nums2 = {4,6,8,10};
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int jNum = 0;
        int iNum = 0;
        while (true){
            jNum = rank(nums2, nums1[iNum]);
            if (jNum != 0){
                iNum = rank(nums1, nums2[jNum - 1]);
            }
            if (iNum + jNum == (m + n + 1) / 2)
                break;
        }
        if ((m+n)%2 == 0){
            return (double) (nums1[iNum-1]+nums2[jNum])/2;
        }
        return Math.max(nums1[iNum-1],nums2[jNum-1]);
    }

    private int rank(int[] nums, int n){
        int lo = 0,hi = nums.length - 1;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            if (nums[mid] == n)
                return mid;
            else if (nums[mid] > n)
                hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}