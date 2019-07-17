package src.s905;

/**
 * @author zft
 * @date 2019/4/16.
 */
public class SortArrayByParitySolution {

	/**
	 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
	 * 你可以返回满足此条件的任何数组作为答案。
	 * 示例：
	 * 输入：[3,1,2,4]
	 * 输出：[2,4,3,1]
	 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
	 * 提示：
	 * 1 <= A.length <= 5000
	 * 0 <= A[i] <= 5000
	 */

	/**
	 * 113ms
	 */
	public static int[] sortArrayByParity(int[] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = A.length - 1; j > i; j--) {
				if (A[i] % 2 == 1 && A[j] % 2 == 0) {
					int temp = A[i];
					A[i] = A[j];
					A[j] = temp;
				}
			}
		}
		return A;
	}

	/**
	 * 2ms
	 */
	public static int[] sortArrayByParity2(int[] A) {
		int left = 0;
		int right = A.length - 1;
		while (left < right) {
			while (left < right && A[left] % 2 == 0) {
				++left;
			}
			while (left < right && A[right] % 2 == 1) {
				--right;
			}
			swap(A, left, right);
		}

		return A;
	}

	private static void swap(int[] A, int left, int right) {
		int temp = A[left];
		A[left] = A[right];
		A[right] = temp;
	}

	public static void main(String[] args) {
		int[] A = new int[]{3, 1, 2, 4};
		int[] ints = sortArrayByParity2(A);
	}

}
