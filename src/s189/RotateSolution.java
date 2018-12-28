package src.s189;

/**
 * @author zft
 * @date 2018/12/28.
 */
public class RotateSolution {

    /*
        给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。

        示例 1:

        输入: [1,2,3,4,5,6,7] 和 k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右旋转 1 步: [7,1,2,3,4,5,6]
        向右旋转 2 步: [6,7,1,2,3,4,5]
        向右旋转 3 步: [5,6,7,1,2,3,4]
        示例 2:

        输入: [-1,-100,3,99] 和 k = 2
        输出: [3,99,-1,-100]
        解释:
        向右旋转 1 步: [99,-1,-100,3]
        向右旋转 2 步: [3,99,-1,-100]

     */

    private static void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i++) {
            int temp = nums[n - 1];
            System.arraycopy(nums, 0, nums, 1, n - 1);
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
    }


}
