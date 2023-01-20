class Solution {
    public int solution(int n) {
        int answer = 0;
        String nStr = Integer.toString(n);
        for(int i=0; i<nStr.length(); i++){
            answer += (int)(nStr.charAt(i)-'0');
            // answer += Character.getNumericValue(nStr.charAt(i));
        }
        return answer;
    }
}