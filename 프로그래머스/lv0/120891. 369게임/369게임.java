class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String num = Integer.toString(order);
        for(int i=0;i<num.length(); i++){
            int n = Character.getNumericValue(num.charAt(i));
            if(n == 3 || n == 6 || n == 9) answer++;
        }
        
        return answer;
    }
}