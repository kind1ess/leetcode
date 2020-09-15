package day001;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution1.longestCommonPrefix(strs));
    }
}
class Solution1{
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0){
            return "";
        }
        if (strs.length == 1){
            return strs[0];
        }
        String s = commonPrefix(strs[0], strs[1]);
        if (strs.length == 2){
            return s;
        }
        for (int i = 2; i < strs.length; i++) {
            if (s.isEmpty()){
                return "";
            }
            s = (commonPrefix(s,strs[i]));
        }
        return s;
    }

    private String commonPrefix(String str1,String str2){
        int length = Math.min(str1.length(), str2.length());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if (str1.charAt(i) == str2.charAt(i))
                sb.append(str1.charAt(i));
            else return sb.toString();
        }
        return sb.toString();
    }
}
