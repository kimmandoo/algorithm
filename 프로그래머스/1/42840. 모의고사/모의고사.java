import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};
        ArrayList<Integer> arr = new ArrayList();
        int max, aa, bb, cc;
        max = aa = bb = cc = 0;
        for(int i=0; i<answers.length; i++){
            int tmp = answers[i];
            if(tmp == a[i%5]) aa++;
            if(tmp == b[i%8]) bb++;
            if(tmp == c[i%10]) cc++;
            if(max < aa) max = aa;
            if(max < bb) max = bb;
            if(max < cc) max = cc;
        }

        if(aa == max) arr.add(1);
        if(bb == max) arr.add(2);
        if(cc == max) arr.add(3);
                        int[] answer = new int[arr.size()];
        int idx = 0;
        for(int i: arr){
            answer[idx++] = i;
        }
        
        return answer;
    }
}