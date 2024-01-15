import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= n; i++) {
            q.offer(i); // 1부터 N까지
        }
        System.out.print("<");
        while (!q.isEmpty()) {
            if (q.size() == 1) {
                System.out.print(q.poll());
            } else {             //k-1만큼 뒤로 보내고, poll
                for (int i = 0; i < k - 1; i++) {
                    q.offer(q.poll());
                }
                System.out.print(q.poll() + ", ");
            }
        }
        System.out.print(">");
    }
}