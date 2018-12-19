package src.s020;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zft
 * @date 2018/12/19.
 */
public class IsVaildSolution {

    /*
        给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
        有效字符串需满足：
        左括号必须用相同类型的右括号闭合。
        左括号必须以正确的顺序闭合。
        注意空字符串可被认为是有效字符串。
        示例 1:
        输入: "()"
        输出: true
        示例 2:
        输入: "()[]{}"
        输出: true
        示例 3:
        输入: "(]"
        输出: false
        示例 4:
        输入: "([)]"
        输出: false
        示例 5:
        输入: "{[]}"
        输出: true
     */

    @SuppressWarnings("unchecked")
    private static Map<Character, Character> map = new HashMap() {{
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    }};

    /**
     * 遍历将开括号放入栈中，当遇到闭括号的时候，弹出栈顶
     * 当栈顶与闭括号所对应的开括号不一致时，false
     *
     * @param str 入参
     * @return 判断结果
     */
    private static boolean isVaild(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (!map.get(c).equals(topElement)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean vaild = IsVaildSolution.isVaild("()(()()())");
        System.out.println(vaild);
    }

}
