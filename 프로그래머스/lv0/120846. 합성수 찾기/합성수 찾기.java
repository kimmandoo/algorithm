import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int i=3;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(i<=n){
            int num = 0;
            for(int j=1;j<=i; j++){
                if(i%j==0) num++;
            }
            if(num>2) {arr.add(num);}
            i++;
        }
        answer = arr.size();
        
        return answer;
    }
}