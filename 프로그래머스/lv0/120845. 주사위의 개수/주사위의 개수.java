class Solution {
    public int solution(int[] box, int n) {
        int answer = 0;
        //n은 정육면체 주사위 모서리 길이
        int w = box[0]/n;
        int h = box[1]/n;
        int d = box[2]/n;
        answer = w*h*d;
        return answer;
    }
}