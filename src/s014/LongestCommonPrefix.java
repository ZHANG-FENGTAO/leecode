package src.s014;

/**
 * @author zft
 * @date 2018/12/18.
 */
public class LongestCommonPrefix {

    /*
        编写一个函数来查找字符串数组中的最长公共前缀。
        如果不存在公共前缀，返回空字符串 ""。
        示例 1:
        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:
        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
     */

    /**
     * 12ms
     *
     * @param strs 入参
     * @return 最长公共前缀
     */
    private static String longestPrint(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        // 判断输入的数组是否空数组
        if (strs.length == 0) {
            System.out.println("");
        } else {
            String src = strs[0];
            for (int i = 0; i < src.length(); i++) {
                // 判断后边的每个数组中的元素与第一个数组中的元素是否相等
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() <= i || strs[j].charAt(i) != src.charAt(i)) {
                        return sb.toString();
                    }
                }
                sb.append(src.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String[] strings = new String[]{"flower", "flow", "flight"};
        String[] strings = new String[]{"ca", "a"};
        String s = longestPrint(strings);
        System.out.println(s);
    }

    /**
     * leecode 5ms
     *
     * @param strs 入参
     * @return 最长公共前缀
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            //拿第一个做模板，匹配到数组中第一个元素的最长公共前缀字符串，然后以这个为模板，以此类推匹配下边所有的元素，最后返回最终模板
            //indexOf是检测子串并返回子串起始位置的函数
            while (strs[i].indexOf(pre) != 0)
            //如果pre不是子串，就去掉pre末尾一位重新比较，直到是子串或者pre长度0时就会跳出本次循环去匹配下一轮外循环
            {
                pre = pre.substring(0, pre.length() - 1);
            }
            i++;
        }
        return pre;
    }

}
