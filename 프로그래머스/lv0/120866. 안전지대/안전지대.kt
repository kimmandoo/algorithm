class Solution {
    fun solution(board: Array<IntArray>): Int {
        var answer: Int = 0
        val n = board[0].size
        // 시계방향 8방
        val dr = arrayOf(-1,-1,0,1,1,1,0,-1)
        val dc = arrayOf(0,1,1,1,0,-1,-1,-1)
        var boardRes = board.clone()
        for(i in 0 until n){
            for(j in 0 until n){
                if(board[i][j] == 1){
                    for(k in 0 until 8){
                        val ni = i + dr[k]
                        val nj = j + dc[k]
                    
                        if(ni>=0 && ni<n && nj >= 0 && nj<n && boardRes[ni][nj] == 0){
                            boardRes[ni][nj] = 2
                        }
                    }
                }
            }
        }
        
        for(i in 0 until n){
            for(j in 0 until n){
                if(boardRes[i][j] == 0) answer++
            }
        }
                
        return answer
    }
}