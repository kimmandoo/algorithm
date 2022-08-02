package leetcode.easy

class p1480 {
    class Solution {
        fun runningSum(nums: IntArray): IntArray {
            val ans = IntArray(nums.size)
            var sum = 0
            for((idx, i) in nums.withIndex()){
                sum += i
                ans[idx] = sum
            }
            return ans
        }
    }
}