package src.s066;

import java.util.Arrays;

/**
 * @author zft
 * @date 2018/12/25.
 */
public class PlusOneSolution {

    /*
        给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

        最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。

        你可以假设除了整数 0 之外，这个整数不会以零开头。

        示例 1:
        输入: [1,2,3]
        输出: [1,2,4]
        解释: 输入数组表示数字 123。
        示例 2:
        输入: [4,3,2,1]
        输出: [4,3,2,2]
        解释: 输入数组表示数字 4321。
     */

    /**
     * 反向遍历
     *
     * @param digits 参数
     * @return 结果
     */
    private static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                return digits;
            }
        }
        int[] returnD = new int[digits.length + 1];
        returnD[0] = 1;
        return returnD;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 9};
        int[] ints = plusOne(nums);
        Arrays.stream(ints).forEach(System.out::println);
    }

}
