import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        ArrayList<Integer> arr = new ArrayList();
        for(int[] comm: commands){
            int s = comm[0]-1; // 0번째 부터 시작
            int e = comm[1]; // n-1까지
            ArrayList<Integer> sorted = new ArrayList();
            for(int i=s; i<e;i++){
                sorted.add(array[i]);
            }
            Collections.sort(sorted);
            
            arr.add(sorted.get(comm[2]-1));
        }
        int idx = 0;
        for(int i: arr){
            answer[idx++] = i;
        }
        
        return answer;
    }
}