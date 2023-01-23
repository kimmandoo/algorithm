import java.util.stream.IntStream;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        //문자열길이 조합
        int[] babLen = new int[]{2, 3, 5, 6, 7, 8, 10};

        for(String baba : babbling){            
            int score = 0;
            if(baba.contains("aya")){
                score += 3;
            }
            if(baba.contains("ye")){
                score += 2;
            }
            if(baba.contains("woo")){
                score += 3;
            }
            if(baba.contains("ma")){
                score += 2;
            }
            if(baba.length() == score) answer++;
        }
        return answer;
    }
}