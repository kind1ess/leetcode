//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 573 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        solution.merge(nums1,3, nums2,3);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i < n; i++) {
            int rank = rank(nums1,m+i, nums2[i]);
            if (nums1[rank] == nums2[i])
                rank++;
            if (m + i - 1 - rank >= 0)
                System.arraycopy(nums1, rank, nums1, rank + 1, m + i - rank);
            nums1[rank] = nums2[i];
        }
    }
    private int rank(int[] nums,int m, int n){
            int lo = 0,hi = m - 1;
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