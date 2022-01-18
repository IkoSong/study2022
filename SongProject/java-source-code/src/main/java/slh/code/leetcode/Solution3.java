package slh.code.leetcode;


//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

import java.util.HashSet;
import java.util.Set;

/**
  * s = "(abcdcbb"
  * 输出: 3
  * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
  **/

public class Solution3 {
     public static int lengthOfLongestSubstring(String s) {
        //滑动窗口算法
         Set<Character> cset = new HashSet<>();
         int left, right = 0,maxLength=0;
         for (left=0; left < s.length(); left++) {
             if(left!=0){
                 cset.remove(s.charAt(left-1));
             }
             while(right<s.length() && !cset.contains(s.charAt(right))){
                 cset.add(s.charAt(right));
                 right++;
             }
            maxLength = Math.max(maxLength,right-left);
         }

         return maxLength;
     }

     public static void main(String[] args) {
//         System.out.println(lengthOfLongestSubstring("abcbcbd"));
//         String test = "abcabcbb";
//         char[] chars = test.toCharArray();
//         System.out.println(test.substring(1,3));
//         System.out.println(test.indexOf("d",1));
         int aa = 0x23;
         int bb = 0x34;

         int cc = aa & bb;
         System.out.println(cc);
         int dd = 0x20;
         System.out.println(cc == dd);
     }




}
