//魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找
//出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。 
//
// 示例1: 
//
//  输入：nums = [0, 2, 3, 4, 5]
// 输出：0
// 说明: 0下标的元素为0
// 
//
// 示例2: 
//
//  输入：nums = [1, 1, 1]
// 输出：1
// 
//
// 提示: 
//
// 
// nums长度在[1, 1000000]之间 
// 
// Related Topics 数组 二分查找 
// 👍 34 👎 0

package top.kindless.leetcode.leetcode.editor.cn;
public class MagicIndexLcci {
    public static void main(String[] args) {
        Solution solution = new MagicIndexLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMagicIndex(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == i)
//                return i;
//        }
//        return -1;
        return findMagicIndex(nums,0,nums.length-1);
    }

    private int findMagicIndex(int[] nums, int left, int right){
        if (left > right)
            return -1;
        int mid = (left + right)/2;
        int leftAnswer = findMagicIndex(nums, left, mid - 1);
        if (leftAnswer > -1)
            return leftAnswer;
        if (nums[mid] == mid)
            return mid;
        return findMagicIndex(nums,mid + 1,right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}