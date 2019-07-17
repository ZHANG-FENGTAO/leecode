package src.s914;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zft
 * @date 2019/4/17.
 */
public class HasGroupsSizeXSolution {

	/**
	 * 给定一副牌，每张牌上都写着一个整数。
	 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
	 * 每组都有 X 张牌。
	 * 组内所有的牌上都写着相同的整数。
	 * 仅当你可选的 X >= 2 时返回 true。
	 * 示例 1：
	 * 输入：[1,2,3,4,4,3,2,1]
	 * 输出：true
	 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
	 * 示例 2：
	 * 输入：[1,1,1,2,2,2,3,3]
	 * 输出：false
	 * 解释：没有满足要求的分组。
	 * 示例 3：
	 * 输入：[1]
	 * 输出：false
	 * 解释：没有满足要求的分组。
	 * 示例 4：
	 * 输入：[1,1]
	 * 输出：true
	 * 解释：可行的分组是 [1,1]
	 * 示例 5：
	 * 输入：[1,1,2,2,2,2]
	 * 输出：true
	 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
	 * 提示：
	 * 1 <= deck.length <= 10000
	 * 0 <= deck[i] < 10000
	 */

	public static boolean hasGroupsSizeX(int[] deck) {

		Map<Integer, Integer> map = new HashMap<>();
		//按不同数字分组，值为出现次数
		for (int i : deck) {
			map.put(i, map.get(i) == null ? 1 : map.get(i) + 1);
		}
		int min = map.get(deck[0]);
		//遍历找出最小的次数
		for (int i : map.keySet()) {
			min = min < map.get(i) ? min : map.get(i);
		}
		//每个数字出现的次数与最小的次数应该有最大公约数
		for (int i : map.keySet()) {
			if (gys(map.get(i), min) <= 1) return false;
		}
		return true;
	}

	private static int gys(int p, int q) {
		if (q == 0) return p;
		return gys(q, p % q);
	}

}
