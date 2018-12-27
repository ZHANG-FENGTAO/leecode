package src.s118;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author zft
 * @date 2018/12/26.
 */
public class GenerateSolution {

    /*
        给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
        在杨辉三角中，每个数是它左上方和右上方的数的和。
        示例:
        输入: 5
        输出:
        [
             [1],
             [1,1],
             [1,2,1],
             [1,3,3,1],
             [1,4,6,4,1]
        ]

     */


    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> target = new LinkedList<>();
        if (numRows == 0) {
            return target;
        }

        target.add(new LinkedList<>());
        // 设置第一行元素
        target.get(0).add(1);

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new LinkedList<>();
            List<Integer> prev = target.get(rowNum - 1);
            // 每一行第一个元素总是1
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            // 每一行最后一个元素是1
            row.add(1);
            target.add(row);
        }
        return target;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(8);
        Objects.requireNonNull(generate).forEach(it -> {
            it.forEach(System.out::println);
        });
    }

}
