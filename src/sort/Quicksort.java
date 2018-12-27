package src.sort;

import java.util.Arrays;

/**
 * @author zft
 * @date 2018/12/27.
 */
public class Quicksort {
    private static int[] numbers;

    private static void sort(int[] values) {
        // 检查数组是否为空
        if (values == null || values.length == 0) {
            return;
        }
        numbers = values;
        int numsLength = values.length;
        quicksort(0, numsLength - 1);
    }

    private static void quicksort(int low, int high) {
        int i = low, j = high;
        // 把数组中间的元素设置为基准数
        int pivot = numbers[low + (high - low) / 2];

        // 分开成两个数组
        while (i <= j) {
            //从左向右“探测”，如果左边的元素小于基准数，则去“探测”下一个元素
            while (numbers[i] < pivot) {
                i++;
            }
            //从右向左“探测”，如果左边的元素大于基准数，则去“探测”下一个元素
            while (numbers[j] > pivot) {
                j--;
            }

            // 如果左边探测结果大于基准数，右边探测结果小于基准数，那么交换这两个元素
            // 然后继续探测
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // 递归
        if (low < j) {
            quicksort(low, j);
        }
        if (i < high) {
            quicksort(i, high);
        }
    }

    private static void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 23, 11, 25, 67, 2, 10, 0, 1};
        sort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }
}