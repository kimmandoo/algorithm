import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int med = array.length/2;
        answer = array[med];
        return answer;
    }
}