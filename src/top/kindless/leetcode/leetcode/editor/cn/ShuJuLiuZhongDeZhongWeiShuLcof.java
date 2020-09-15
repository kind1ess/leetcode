//如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数
//值排序之后中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例 1： 
//
// 输入：
//["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
//[[],[1],[2],[],[3],[]]
//输出：[null,null,null,1.50000,null,2.00000]
// 
//
// 示例 2： 
//
// 输入：
//["MedianFinder","addNum","findMedian","addNum","findMedian"]
//[[],[2],[],[3],[]]
//输出：[null,null,2.00000,null,2.50000] 
//
// 
//
// 限制： 
//
// 
// 最多会对 addNum、findMedia进行 50000 次调用。 
// 
//
// 注意：本题与主站 295 题相同：https://leetcode-cn.com/problems/find-median-from-data-strea
//m/ 
// Related Topics 堆 设计 
// 👍 53 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.Arrays;

public class ShuJuLiuZhongDeZhongWeiShuLcof {
    public static void main(String[] args) {
//        Solution solution = new ShuJuLiuZhongDeZhongWeiShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class MedianFinder {
    //todo incorrect answer
    private int[] nums;
    private int size;
    /** initialize your data structure here. */
    public MedianFinder() {
        nums = new int[10];
        size = 0;
    }

    public void addNum(int num) {
        int length;
        if (size+1 >= (length = nums.length)){
            resize(length + length >> 1);
        }
        int rank = rank(num);
        for (int i = size++; i > rank; i--) {
            nums[i] = nums[i-1];
        }
        nums[rank] = num;
    }
    
    public double findMedian() {
        if ((size & 1) != 0){
            return nums[size / 2];
        }
        return size == 0 ? 0 : (double) (nums[size / 2] + nums[(size / 2) - 1]) / 2;
    }

    private void resize(int size){
        nums = Arrays.copyOf(nums,size);
    }

    private int rank(int num){
        int lo = 0,hi = size - 1;
        int mid;
        while (lo <= hi){
            mid = (hi + lo)/2;
            if (nums[mid] == num){
                return mid;
            }
            else if (nums[mid] > num){
                hi = mid - 1;
            }
            else lo = mid + 1;
        }
        return lo;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}