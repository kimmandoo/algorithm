class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        int no1 = 0;
        int no1Idx = 0;
        int no2 = 0;
        
        for(int i=0; i<numbers.length; i++){
            if(no1 < numbers[i]){
                no1 = numbers[i];
                no1Idx = i;
            } 
        }
        for(int i=0; i<numbers.length; i++){
            if(no1 == numbers[i]){
                if(i != no1Idx){
                    no2 = numbers[i];
                }
            }else if(no2 < numbers[i]){
                no2 = numbers[i];
            }
        }
        
        answer = no1*no2;
        return answer;
    }
}