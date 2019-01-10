package src.s283;

import java.util.Arrays;

/**
 * @author zft
 * @date 2019/1/10.
 */
public class MoveZeroesSolution {

    /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

        示例:

        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
        说明:

        必须在原数组上操作，不能拷贝额外的数组。
        尽量减少操作次数。
     */

    private static int[] moveZero(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 3, 12};
        int[] ints = moveZero(nums);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
