package src.s001;

import java.util.HashMap;

/**
 * s001
 *
 * @author zft
 * @date 2018/2/6
 */
public class TwoSum {

    /**
     * Description
     * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * Example:
     * Given nums = [2, 7, 11, 15], target = 9,
     * Because nums[0] + nums[1] = 2 + 7 = 9,
     * return [0, 1].
     * Tags: Array, Hash Table
     */

    private static int[] twoSum(int[] nums, int target) {
        int[] targets = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    targets[0] = i;
                    targets[1] = j;
                    return targets;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 11, 7, 15};
        Integer target = 9;
        int[] ints = twoSum2(a, target);
        assert ints != null;
        for (int anInt : ints) {
            System.out.println("ints=" + anInt);
        }
    }

    /**
     * 将当前索引的所需值存储在key中，将自己索引存储在value,直到循环到所需值，取value索引.
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }


}
