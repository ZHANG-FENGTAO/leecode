package src.s888;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zft
 * @date 2019/2/26.
 */
public class FindCandySwapSolution {

	/**
	 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i] 是爱丽丝拥有的第 i 块糖的大小，B[j] 是鲍勃拥有的第 j 块糖的大小。
	 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。（一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
	 * 返回一个整数数组 ans，其中 ans[0] 是爱丽丝必须交换的糖果棒的大小，ans[1] 是 Bob 必须交换的糖果棒的大小。
	 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
	 * 示例 1：
	 * 输入：A = [1,1], B = [2,2]
	 * 输出：[1,2]
	 * <p>
	 * 示例 2：
	 * 输入：A = [1,2], B = [2,3]
	 * 输出：[1,2]
	 * 示例 3：
	 * <p>
	 * 输入：A = [2], B = [1,3]
	 * 输出：[2,3]
	 * 示例 4：
	 * <p>
	 * 输入：A = [1,2,5], B = [2,4]
	 * 输出：[5,4]
	 */

	public static int[] findCandySwap(int[] A, int[] B) {
		int sumA = 0, sumB = 0, del = 0;
		Set<Integer> set = new HashSet<>(B.length);
		for (int i = 0; i < A.length; i++) {
			sumA += A[i];
		}

		for (int i = 0; i < B.length; i++) {
			set.add(B[i]);
			sumB +=B[i];
		}
		del = (sumB - sumA) / 2;
		for (int i = 0; i < A.length; i++) {
			if (set.contains(A[i] + del)) {
				return new int[]{A[i], A[i] + del};
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] A = new int[]{1, 1};
		int[] B = new int[]{2, 2};
		int[] candySwap = findCandySwap(A, B);
		assert candySwap != null;
		System.out.println(candySwap[0] + "  " + candySwap[1]);
	}


}
