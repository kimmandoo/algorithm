class Solution {
    fun solution(M: Int, N: Int): Int {
        var answer: Int = 0
        if(M-N<=0){
            // N이 더 큰 변인 경우
            answer += M-1 + (M)*(N-1)
        }else{
            answer += N-1 + (M-1)*(N)
        }
        
        
        return answer
    }
}