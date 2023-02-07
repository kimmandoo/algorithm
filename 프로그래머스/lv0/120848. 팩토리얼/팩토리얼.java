class Solution {
    public int solution(int n) {
        int[] facto = new int[10];
        int answer = 0;
        facto[0] = factorial(1);
        facto[1] = factorial(2);
        facto[2] = factorial(3);
        facto[3] = factorial(4);
        facto[4] = factorial(5);
        facto[5] = factorial(6);
        facto[6] = factorial(7);
        facto[7] = factorial(8);
        facto[8] = factorial(9);
        facto[9] = factorial(10);
        int idx = 1;
        
        for(int i: facto){
            if(i <= n){
                answer = idx;
                idx++;
            }else{
                break;
            } 
        }
        
        return answer;
    }
    public static int factorial(int n){
        if(n<2){
            return n;
        }
        else {
            return n*factorial(n-1);
        }
    }
}