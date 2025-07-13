class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int wh = (brown+4)/2;
        // w >= h

        for(int w=wh; w > 2; w--){
            for(int h=2; h<=wh; h++){
                if((w-2)*(h-2) == yellow && w * h == brown + yellow) {
                    return new int[]{w,h};
                }
            }   
        }
        
        return answer;
    }
}