import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Arrays.sort(numbers);
    
        answer = numbers[numbers.length-1]*numbers[numbers.length-2];
        if(numbers[1] < 0){
            // 음수 곱
            int tmpMax = numbers[0]*numbers[1];
            if(answer < tmpMax) answer = tmpMax;
        }
        
//         int[] pro = new int[numbers.length];
//         int[] con = new int[numbers.length];
//         int idxP = 0;
//         int idxC = 0;

//         for(int i: numbers){
//             if(i>0){
//                 pro[idxP++] = i;
//             }else{
//                 con[idxC++] = i;
//             }
//         }
        
//         Arrays.sort(pro);
//         Arrays.sort(con);
        
//         answer = pro[pro.length-1]*pro[pro.length-2];
        
//         if(con[1] != 0){
//             // 음수 곱
//             int tmpMax = con[0]*con[1];
//             if(answer < tmpMax) answer = tmpMax;
//         }
        
        return answer;
    }
}