import java.util.*;

class Solution {
    public int solution(int len, int w, int[] trucks) {
        // 다리를 나타내는 큐
        Queue<Integer> bridge = new LinkedList<>();
        // 대기 트럭 큐
        Queue<Integer> q = new LinkedList<>();
        for (int truck : trucks) {
            q.offer(truck);
        }

        // 다리 길이만큼 0으로 채워 초기화
        for (int i = 0; i < len; i++) {
            bridge.offer(0);
        }

        int time = 0;
        int curW = 0; // 현재 다리 위 무게

        // 대기 트럭이 없을 때까지 반복
        while (!q.isEmpty()) {
            time++;

            // 1. 다리에서 한 칸 이동 (맨 앞 요소 제거)
            curW -= bridge.poll();

            // 2. 새 트럭이 진입 가능한지 확인
            if (curW + q.peek() <= w) {
                int truck = q.poll();
                bridge.offer(truck);
                curW += truck;
            } else {
                // 진입 불가 시, 0을 넣어 빈 공간으로 채움
                bridge.offer(0);
            }
        }

        return time + len;
    }
}