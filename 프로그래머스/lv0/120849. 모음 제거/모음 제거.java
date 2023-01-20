class Solution {
    public String solution(String my_string) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            String value = Character.toString(my_string.charAt(i));
            if(!"aeiou".contains(value)) answer+=value;
        }
        return answer;
    }
}