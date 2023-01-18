class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        int len1 = s1.length;
        int len2 = s2.length;
        for(int i=0; i<len1; i++){
            for(int j=0; j<len2; j++){
                if(s1[i].equals(s2[j])) answer++;
            }
        }
        
    
        return answer;
    }
}