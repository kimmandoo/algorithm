class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int k : array){
            String input = Integer.toString(k);
            for(int i=0; i<input.length(); i++){
                if(input.charAt(i) == '7') answer++;
            }
        }
        return answer;
    }
}