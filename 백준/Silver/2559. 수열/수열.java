import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, gap;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        gap = Integer.parseInt(st.nextToken());
        int[] in = new int[n];
        int[] prefix = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
            prefix[i+1] = prefix[i] + in[i];
        }
//        System.out.println(Arrays.toString(prefix));

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        //이제 각 간격의 합을 pq에 넣기
        int idx = n;
        while (true) {
            if (idx - gap < 0) break;
            pq.add(prefix[idx] - prefix[idx - gap]);
            idx--;
        }

        System.out.println(pq.poll());
    }
}