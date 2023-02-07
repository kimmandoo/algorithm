class Solution {
    public int solution(int num, int k) {
        int answer = -1;
        String numS = Integer.toString(num);

        boolean find = false;
        for(int i=0; i<numS.length(); i++){
            if(k == Character.getNumericValue(numS.charAt(i)) && find == false){
                answer = i+1;
                find = true;
            }
        }
        
        return answer;
    }
}