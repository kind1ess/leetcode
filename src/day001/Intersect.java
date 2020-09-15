package day001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Intersect {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2};
        int[] intersect = solution.intersect(nums1, nums2);
        for (int i : intersect) {
            System.out.println(i);
        }
    }
}

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        if(nums1.length<nums2.length){
            for (int value : nums1) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            for (int value : nums2) {
                Integer temp = map.get(value);
                if (temp != null && temp > 0) {
                    list.add(value);
                    map.put(value, temp - 1);
                }
            }
        }else{
            for (int value : nums2) {
                map.put(value, map.getOrDefault(value, 0) + 1);
            }
            for (int value : nums1) {
                Integer temp = map.get(value);
                if (temp != null && temp > 0) {
                    list.add(value);
                    map.put(value, temp - 1);
                }
            }
        }
        int[] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(i);
        }
        return result;
    }
}