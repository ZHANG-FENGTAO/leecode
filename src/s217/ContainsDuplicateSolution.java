package src.s217;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zft
 * @date 2018/12/29.
 */
public class ContainsDuplicateSolution {

    /*
        给定一个整数数组，判断是否存在重复元素。

        如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。

        示例 1:

        输入: [1,2,3,1]
        输出: true
        示例 2:

        输入: [1,2,3,4]
        输出: false
        示例 3:

        输入: [1,1,1,3,3,4,3,2,4,2]
        输出: true

     */

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        boolean b = containsDuplicate(nums);
        System.out.println(b);
    }

}