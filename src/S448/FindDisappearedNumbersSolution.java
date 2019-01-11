package src.S448;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zft
 * @date 2019/1/11.
 */
public class FindDisappearedNumbersSolution {

    /*
        给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。

        找到所有在 [1, n] 范围之间没有出现在数组中的数字。
        
        您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
        
        示例:
        
        输入:
        [4,3,2,7,8,2,3,1]
        
        输出:
        [5,6]
     */

    private static List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> results = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                results.add(i + 1);
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> list = findDisappearedNumbers(nums);
        list.forEach(System.out::println);
    }
}
