//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。 
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 哈希表 
// 👍 1395 👎 0

package top.kindless.leetcode.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int num : nums) {
//            if (!map.containsKey(num))
//                map.putIfAbsent(num,1);
//            else map.put(num,map.get(num)+1);
//        }
//        for (int num : nums) {
//            if (map.get(num).equals(1))
//                return num;
//        }
//        return -1;
        //大佬的异或，记一下
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}