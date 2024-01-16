import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int pick = sc.nextInt();
        int cnt = 0;
        LinkedList<Integer> dq = new LinkedList<>();
        // ArrayDeque 을 사용한 deque은 indexOf가 없다.
        for (int i = 1; i <= n; i++) {
            dq.offer(i);
        }
        for (int i = 0; i < pick; i++) {
            int t = sc.nextInt();
            // 타겟 위치 탐색
            int target = dq.indexOf(t);
            int m= dq.size() / 2;
//            if (dq.size() % 2 == 0) {
//                m = dq.size() / 2 - 1;
//            } else {
//                m = dq.size() / 2;
//            }
            if (!dq.isEmpty() && t != dq.peekFirst()) {
                if (target <= m) { // 타겟이 왼쪽에 위치한 경우 -> 왼쪽으로 돌림
                    for (int j = 0; j < target; j++) {
                        dq.addLast(dq.pollFirst());
                        cnt++;
                    }
                    int tmp = dq.pollFirst();
//                    System.out.println(tmp);
                } else {
                    for (int j = 0; j < dq.size() - target; j++) {
                        dq.addFirst(dq.pollLast());
                        cnt++;
                    }
                    int tmp = dq.pollFirst();
//                    System.out.println(tmp);
                }
            } else {
                dq.pollFirst();
            }
        }
        System.out.println(cnt);
    }
}