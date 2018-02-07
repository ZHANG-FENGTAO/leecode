package m003;

/**
 * RepereatSubstring
 *
 * @author zft
 * @date 2018/2/6
 */
public class RepereatSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int l = i - preP + 1;
            hash[c] = i + 1;
            if (l > max) max = l;
        }
        return max;
    }

    public static void main(String[] args) {

        String s = "kwfgdfgh";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
}
