import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, m, k;
    public static StringBuilder sb;
    public static int[] input;
    public static Integer[] idx;
    static boolean[] v;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        }); // maxHeap만들기

        st = new StringTokenizer(br.readLine());
        int days = 0;
        long total = 0;

        for (int i = 0; i < n; i++) {
            int milk = Integer.parseInt(st.nextToken());
            total += milk;
            pq.offer(milk); // 우유를 계속 담으면서 maxHeap으로 관리하기

            // 현재까지의 우유 섭취량이 가진 우유량을 초과하는 경우
            if (total > m) {
                // 비스킷이 남아있고, 교체할 우유가 있는 경우
                if (k > 0 && !pq.isEmpty()) {
                    // 가장 많은 우유가 필요한 날을 비스킷으로 대체
                    total -= pq.poll(); // 비스킷으로 치환하기
                    k--;
                } else {
                    // 다 먹음
                    System.out.print(i);
                    return;
                }
            }
            days = i + 1;
        }
        // 왜ㄹ이리어렵지
        System.out.print(days);
    }

    static int max = Integer.MIN_VALUE;

    public static void go(int day, int milk, int bis, int cnt) {
        if (day == n || (milk < input[day] && bis == 0)) {
            max = Math.max(max, cnt);
            return;
        }

        // 우유 마시기
        if (milk >= input[day]) {
            go(day + 1, milk - input[day], bis, cnt + 1);
        }

        // 비스킷 먹기
        if (bis > 0) {
            go(day + 1, milk, bis - 1, cnt + 1);
        }
    }
}