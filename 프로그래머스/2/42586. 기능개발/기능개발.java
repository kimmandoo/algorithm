import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<int[]> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();

        // progresses와 speeds를 묶어서 큐에 넣기
        for (int i = 0; i < progresses.length; i++) {
            q.offer(new int[]{progresses[i], speeds[i]});
        }

        while (!q.isEmpty()) {
            // 하루씩 진도 증가
            for (int[] task : q) {
                task[0] += task[1];
            }

            int cnt = 0;
            // 앞에서부터 완료된 기능만 묶어서 배포
            while (!q.isEmpty() && q.peek()[0] >= 100) {
                q.poll();
                cnt++;
            }

            if (cnt > 0) {
                res.add(cnt);
            }
        }

        // ArrayList → int[]
        int[] answer = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }
}
