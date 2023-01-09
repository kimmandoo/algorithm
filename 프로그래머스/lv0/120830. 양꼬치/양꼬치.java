class Solution {
    public int solution(int n, int k) {
        // 양꼬치 n인분 음료수 k개
        int answer = 0;
        
        int yang = 12000;
        int bev = 2000;
        if(n / 10 > 0){
            k= k-n/10;
        }
        answer = yang*n + bev*k;
        
        return answer;
    }
}