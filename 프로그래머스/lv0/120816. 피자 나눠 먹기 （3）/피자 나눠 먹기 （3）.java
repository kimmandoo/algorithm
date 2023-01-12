class Solution {
    public int solution(int slice, int n) {
        int answer = 0;
        // slice 조각수, n 먹을사람수
        if(slice>=n){
            answer = 1;
        }
        if(slice<n){
            if(n%slice == 0){
                answer = n/slice;
            }else{
                answer = (int)Math.ceil(n/(double)slice);
            }
        }
        
        return answer;
    }
}