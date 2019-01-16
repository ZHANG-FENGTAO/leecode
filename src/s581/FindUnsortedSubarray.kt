package src.s581

/**
 * @author zft
 * @date 2019/1/15.
 */

/*
    给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
    你找到的子数组应是最短的，请输出它的长度。
    示例 1:
    输入: [2, 6, 4, 8, 10, 9, 15]
    输出: 5
    解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
    说明 :
    输入的数组长度范围在 [1, 10,000]。
    输入的数组可能包含重复元素 ，所以升序的意思是<=。
 */

fun findUnsortedSubarray(nums: IntArray): Int {
    val copyOfRange = nums.copyOfRange(0, nums.size)
    copyOfRange.sort()
    var i = 0
    var j = nums.size - 1
    while (i < j) {
        var flag = false
        if (copyOfRange[i] == nums[i]) {
            i++;flag = true
        }
        if (copyOfRange[j] == nums[j]) {
            j--;flag = true
        }
        if (!flag) {
            break
        }
    }
    if (i >= j) {
        return 0
    }
    return j - i + 1
}

fun main(args: Array<String>) {
//    val nums = intArrayOf(2, 6, 4, 8, 10, 9, 15)
    val nums = intArrayOf(1)
    val subarray = findUnsortedSubarray(nums)
    println(subarray)
}