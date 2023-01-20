class Solution {
    public int solution(String my_string) {
        int answer = 0;
        for(int i=0; i<my_string.length(); i++){
            char value = my_string.charAt(i);
            if((int)'0' < (int)value && (int)value <= (int)'9'){
                answer += Character.getNumericValue(value);
            }
        }
        return answer;
    }
}