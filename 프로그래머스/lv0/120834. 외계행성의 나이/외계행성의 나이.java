class Solution {
    public String solution(int age) {
        String answer = "";
        String[] str = new String[]{"a","b","c","d","e","f","g","h","i","j"};
        String ageS = Integer.toString(age);
        for(int i =0; i<ageS.length(); i++){
            int c = Character.getNumericValue(ageS.charAt(i));
            answer += str[c];
        }
        
        return answer;
    }
}