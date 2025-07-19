import java.util.*;

class Solution {
    static class Node {
        int idx, pr;
        Node(int i, int p) {
            idx = i;
            pr = p;
        }
    }

    public int solution(int[] pr, int l) {
        int answer = 0;
        int[] freq = new int[10];
        for (int i : pr) {
            freq[i]++;
        }

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < pr.length; i++) {
            q.offer(new Node(i, pr[i]));
        }

        int cnt = 0;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            boolean hasHigher = false;

            for (int i = cur.pr + 1; i < 10; i++) {
                if (freq[i] > 0) {
                    hasHigher = true;
                    break;
                }
            }

            if (hasHigher) {
                q.offer(cur);
            } else {
                freq[cur.pr]--;
                cnt++;
                if (cur.idx == l) {
                    return cnt;
                }
            }
        }

        return -1; // 여기에 도달하면 안 됨
    }
}