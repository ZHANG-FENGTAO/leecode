package src.s009;

/**
 * @author zft
 * @date 2018/12/18.
 */
public class PalindromeSolution {

    /*
     * 示例 1:
     * 输入: 121
     * 输出: true
     * 示例 2:
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     */

    private static boolean isPalindrome(int x) {
        // 先判断参数是否小于0 或者取模10 为0
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int revertNum = 0;
        while (x > revertNum) {
            revertNum = revertNum * 10 + x % 10;
            x /= 10;
        }

        // 当这个数为偶数时 x == revertNum
        // 当这个数为奇数时 x == revertNum / 10
        return x == revertNum || x == revertNum / 10;
    }

    public static void main(String[] args) {
        boolean palindrome = isPalindrome(981189);
        System.out.println(palindrome);
    }

}
