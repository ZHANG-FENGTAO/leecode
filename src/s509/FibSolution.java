package src.s509;

/**
 * @author zft
 * @date 2019/1/11.
 */
public class FibSolution {

    /*
        斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：

        F(0) = 0,   F(1) = 1
        F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
        给定 N，计算 F(N)。
        示例 1：
        输入：2
        输出：1
        解释：F(2) = F(1) + F(0) = 1 + 0 = 1.

        示例 2：
        输入：3
        输出：2
        解释：F(3) = F(2) + F(1) = 1 + 1 = 2.

        示例 3：
        输入：4
        输出：3
        解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
        提示：
        0 ≤ N ≤ 30
     */

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    /**
     * 斐波那契数列 公式
     * F(n)=(1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
     */
    private static int fib2(int N) {
        if (N == 1 || N == 2) {
            return 1;
        }
        double sqrtFive = Math.sqrt(5);
        double addN = Math.pow(1 + sqrtFive, N);
        double reduceN = Math.pow((1 - sqrtFive), N);
        return (int) ((1 / sqrtFive) * ((addN - reduceN) / Math.pow(2, N)));
    }

    public static void main(String[] args) {
        System.out.println(fib2(30));
    }
}
