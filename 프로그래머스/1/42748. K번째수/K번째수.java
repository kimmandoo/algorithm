import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> arr = new ArrayList();
        int[] answer = new int[commands.length];
        int idx = 0;
        for(int[] cmd: commands){
            // 정렬된 i부터 j번째 사이의 k번째 수
            for(int i=cmd[0]-1; i<cmd[1]; i++){
                arr.add(array[i]);
            }
            Collections.sort(arr);
            answer[idx++] = arr.get(cmd[2]-1);
            arr.clear();
        }
        
        return answer;
    }
}