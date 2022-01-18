package slh.code.leetcode;

//Two Sum

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 你可以按任意顺序返回答案。
 *
 */

//Map<nums[i],i>
//key   value
// 2     0
// 7     1
// 11    2
// 15    3
//nums = [2,7,11,15], target = 9
public class Solution1 {
    public static void main(String[] args) {
        Solution1 s  = new Solution1();
        System.out.println(Arrays.toString(s.twoSum(new int[]{1,2,5, 12}, 13)));
    }


    public static int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> targetMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(targetMap.containsKey(target - nums[i])){
                return new int[]{targetMap.get(target-nums[i]),i};
            }
            targetMap.put(nums[i],i);
        }
        return null;
    }
}
