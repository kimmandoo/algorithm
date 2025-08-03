import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        LinkedList<Integer> stack = new LinkedList(); // 가격이 떨어지지 않은 시점을 저장할 스택

        for (int i = 0; i < n; i++) {
            // 스택이 비어있지 않고, 현재 가격이 스택의 top에 있는 가격보다 낮다면 -> 가격이 떨어진 것
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int topIdx = stack.pop(); // 가격이 떨어진 시점의 인덱스
                answer[topIdx] = i - topIdx; // 현재 시점 - 과거 시점 = 유지된 기간
            }
            
            // 현재 시점의 인덱스를 스택에 push
            stack.push(i);
        }

        // 끝난 후에도 스택에 남아있는 인덱스들 처리 -> 끝까지 가격이 떨어지지 않은 주식들
        while (!stack.isEmpty()) {
            int topIdx = stack.pop();
            answer[topIdx] = (n - 1) - topIdx; // 전체 기간 - 해당 시점 = 유지된 기간
        }

        return answer;
    }
}