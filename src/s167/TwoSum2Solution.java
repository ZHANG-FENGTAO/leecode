package src.s167;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zft
 * @date 2018/12/27.
 */
public class TwoSum2Solution {

    /*
        给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。

        函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

        说明:

        返回的下标值（index1 和 index2）不是从零开始的。
        你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
        示例:

        输入: numbers = [2, 7, 11, 15], target = 9
        输出: [1,2]
        解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
     */

    private static int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>(numbers.length / 2 + 1);
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(target - numbers[i], i);
            } else {
                Integer index = map.get(numbers[i]);
                res[0] = index + 1;
                res[1] = i + 1;
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15, 27};
        int[] ints = twoSum(nums, 42);
        assert ints != null;
        Arrays.stream(ints).forEach(System.out::println);
    }

}
