class Solution {
    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int idx = 0;
        int getIdx = 0;
        int max=array[0];
        for(int i: array){
            if(max<i){
                max = i;
                getIdx=idx;
            } 
            idx++;
        }
        answer[0] = max;
        answer[1] = getIdx;
        return answer;
    }
}