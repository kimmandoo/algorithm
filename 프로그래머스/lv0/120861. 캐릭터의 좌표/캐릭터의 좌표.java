class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0,0}; // x, y
        //
        int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}}; // u, d, l, r
        
        int w = board[0];
        int h = board[1];
        int maxW = (w-1)/2;
        int maxH = (h-1)/2;

        for(String input: keyinput){
            if(input.equals("up")){
                answer[0] += dir[0][0];
                answer[1] += dir[0][1];
                if(Math.abs(answer[0]) > maxW) answer[0] -= dir[0][0];
                if(Math.abs(answer[1]) > maxH) answer[1] -= dir[0][1];
            }
            if(input.equals("down")){
                answer[0] += dir[1][0];
                answer[1] += dir[1][1];
                if(Math.abs(answer[0]) > maxW) answer[0] -= dir[1][0];
                if(Math.abs(answer[1]) > maxH) answer[1] -= dir[1][1];
            }
            if(input.equals("left")){
                answer[0] += dir[2][0];
                answer[1] += dir[2][1];
                if(Math.abs(answer[0]) > maxW) answer[0] -= dir[2][0];
                if(Math.abs(answer[1]) > maxH) answer[1] -= dir[2][1];
            }
            if(input.equals("right")){
                answer[0] += dir[3][0];
                answer[1] += dir[3][1];
                if(Math.abs(answer[0]) > maxW) answer[0] -= dir[3][0];
                if(Math.abs(answer[1]) > maxH) answer[1] -= dir[3][1];
            }
        }
        
        return answer;
    }
}