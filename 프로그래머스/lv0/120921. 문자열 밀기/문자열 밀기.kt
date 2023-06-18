class Solution {
    fun solution(A: String, B: String): Int {
        var answer: Int = 0
        val len = A.length
        val arrayA = A.toCharArray()
        val arrayB = B.toCharArray()
        var idx = 0;
        for((i, value) in arrayB.withIndex()){
            if(arrayA[0] == value){
                idx = i
                if(A.substring(0,len-idx).equals(B.substring(idx,len)) and A.substring(len-idx,len).equals(B.substring(0,idx))){
                    answer = idx
                    break 
                }else{
                    answer = -1
                }
            } 
        }
        
        
        return answer
    }
}