import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        LinkedList<Integer> s = new LinkedList();
        ArrayList<Integer> a = new ArrayList();
        for(int i: arr){
            if(s.size()>0 && s.peek() != i){
                a.add(s.pop());
                s.push(i);
            }else{
                s.push(i);
            }
        }
        a.add(s.pop());

        int[] answer = new int[a.size()];
        int idx =0 ;
        for(Integer i: a){
            answer[idx++] = i;
        }

        return answer;
    }
}