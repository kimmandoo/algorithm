class Solution {
    public int solution(int hp) {
        int answer = 0;
        int leftHp = hp;
        while(hp > 0){
            if(hp>= 5){
                answer+=1;
                hp-=5;
            }else if(hp>=3){
                answer+=1;
                hp-=3;
            }else{
                answer+=1;
                hp-=1;
            }
        }
        return answer;
    }
}