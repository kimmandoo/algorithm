import java.util.Arrays;

class Solution {
    public int solution(String before, String after) {
        int answer = 1;
        int len = before.length();
        int[] b = new int[len];
        int[] a = new int[len];
        
        for(int i=0; i<len; i++){
            b[i] = before.charAt(i);
            a[i] = after.charAt(i);
        }
        
        Arrays.sort(b);
        Arrays.sort(a);
        int idx = 0;
        for(int i: a){
            if(b[idx++] != i) answer = 0;
        }
        
        return answer;
    }
}