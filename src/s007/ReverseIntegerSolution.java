package src.s007;

/**
 * @author zft
 * @date 2018/12/18.
 */
public class ReverseIntegerSolution {

    private int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10) {
            res = res * 10 + x % 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }

    public static void main(String[] args) {
        ReverseIntegerSolution reverseIntegerSolution = new ReverseIntegerSolution();
        System.out.println(reverseIntegerSolution.reverse(123));
        System.out.println(reverseIntegerSolution.reverse(-123));
        System.out.println(reverseIntegerSolution.reverse(100));
        System.out.println(reverseIntegerSolution.reverse(1000000003));
    }
}
