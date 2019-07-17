package src.s532;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author zft
 * @date 2019/1/14.
 */
public class FindPairsSolution {

    /*
        给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。
        这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.

        示例 1:
        输入: [3, 1, 4, 1, 5], k = 2
        输出: 2
        解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
        尽管数组中有两个1，但我们只应返回不同的数对的数量。

        示例 2:
        输入:[1, 2, 3, 4, 5], k = 1
        输出: 4
        解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。

        示例 3:
        输入: [1, 3, 1, 5, 4], k = 0
        输出: 1
        解释: 数组中只有一个 0-diff 数对，(1, 1)。

        注意:
        数对 (i, j) 和数对 (j, i) 被算作同一数对。
        数组的长度不超过10,000。
        所有输入的整数的范围在 [-1e7, 1e7]。
     */

    //1，首先利用map统计元素出现的频次key = num，value = 频次；
    // 2，遍历map统计 key + k 出现的次数（如果k == 0，统计的是 value > 1 这样的键值对的个数）

    private static int findPairs(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>(nums.length);
        int count = 0;
        for (Integer num : nums) {
            if (k == 0 && hashMap.getOrDefault(num, 0) > 0 && hashMap.get(num) < 2) {
                count++;
                hashMap.put(num, 2);
            } else if (k == 0 && hashMap.getOrDefault(num, 0) > 0) {
                continue;
            } else {
                hashMap.put(num, 1);
            }
        }
        if (k > 0) {
            for (Integer key : hashMap.keySet()) {
                if (hashMap.getOrDefault(key + k, 0) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

//    public static void main(String[] args) {
//        int[] nums = new int[]{1, 3, 1, 5, 4};
//        int pairs = findPairs(nums, 0);
//        System.out.println(pairs);
//    }

//    public static int pivotIndex(int[] nums) {
//        if (nums.length < 3) {
//            return -1;
//        }
//        int sum = Arrays.stream(nums).sum();
//        double sumMid = sum / 2d;
//        int left = nums[0];
//        if (sum - left == 0) {
//            return 0;
//        }
//        for (int i = 1; i < nums.length; i++) {
//            if (left + (nums[i] / 2d) == sumMid) {
//                return i;
//            } else {
//                left += nums[i];
//            }
//        }
//        return -1;
//    }

    public static String shortestCompletingWord(String licensePlate, String[] words) {
        licensePlate = licensePlate.toLowerCase().replaceAll(" ", "").replaceAll("\\d+", "");
        int minLength = 15;
        Map<String, Integer> map = new LinkedHashMap<>(words.length);
        for (String word : words) {
            String copy = word;
            boolean flag = true;
            for (int j = 0; j < licensePlate.length(); j++) {
                String s = String.valueOf(licensePlate.charAt(j));
                if (!copy.contains(s)) {
                    flag = false;
                    break;
                } else {
                    copy = copy.replaceFirst(s, "");
                }
            }
            if (flag) {
                minLength = minLength < word.length() ? minLength : word.length();
                map.put(word, word.length());
            }
        }
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() <= minLength) {
                return entry.getKey();
            }
        }
        return "";
    }


//    public static void main(String[] args) {
//        String[] words = {"step", "steps", "stripe", "stepple"};
//        String licensePlate = "1s3 PSt";
//        String s = shortestCompletingWord(licensePlate, words);
//        System.out.println(s);
//    }


    public static int test(int a) {
        if (a == 1 || a == 2) {
            return 1;
        } else {
            return test(a - 1) + test(a - 2);
        }
    }

    public static void main(String[] args) {
        int test = test(5);
        System.out.println(test);
    }

}
