import kotlin.math.*

class Solution {
    fun solution(dots: Array<IntArray>): Int {
        dots.sortBy { it.first() }
    
        val a = Math.abs(dots[0][1] - dots[1][1])
        val b = Math.abs(dots[2][0] - dots[1][0])
        
        var answer: Int = a*b
        
        return answer
    }
}