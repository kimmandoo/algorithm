class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        int lenS = spell.length;
        
        for(String i : dic){
            String input = i;
            
            if(input.length() == lenS){
                for(int j=0; j<lenS; j++){
                
                input = input.replaceFirst(spell[j],"");
                if(input.isEmpty()) answer = 1;
                }
            }
        }
        
        return answer;
    }
}