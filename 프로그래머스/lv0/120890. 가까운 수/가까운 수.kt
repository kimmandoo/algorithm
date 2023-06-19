import kotlin.math.*

class Solution {
    fun solution(array: IntArray, n: Int): Int {
        var answer: Int = 0
        val sorted = array.sorted() // 정렬된 배열이라고 안나오니까
        var min: Int = 100
        
        for(i in sorted){
            val tmp = abs(i-n)
            if(min > tmp){
                min = tmp // 이러면 같은 경우 먼저 온게 저장 될 것.
                answer = i
            }
        }

        return answer
    }
}