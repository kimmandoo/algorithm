import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        boolean[] inserted = new boolean[jobs.length]; // jobs가 큐에 들어갔는지 표시
        PriorityQueue<Disk> pq = new PriorityQueue<>((a, b) -> a.elp - b.elp); // SJF
        int now = 0;
        int sum = 0;
        int count = 0;

        while (count < jobs.length) {
            // 현재 시간에 들어올 수 있는 job을 모두 우선순위 큐에 넣는다
            for (int i = 0; i < jobs.length; i++) {
                if (!inserted[i] && jobs[i][0] <= now) {
                    pq.offer(new Disk(i, jobs[i][0], jobs[i][1]));
                    inserted[i] = true;
                }
            }

            if (!pq.isEmpty()) {
                Disk job = pq.poll();
                now += job.elp;
                sum += (now - job.time);
                count++;
            } else {
                now++; // 처리 가능한 job이 없으면 시간만 흐름
            }
        }

        return sum / jobs.length;
    }
}

class Disk {
    int num, time, elp;
    Disk(int n, int t, int e) {
        num = n;
        time = t;
        elp = e;
    }
}
