import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static String t;
    static LinkedList<Integer> list; //섞고나서 카드를 저장할 리스트
    static StringBuilder res = new StringBuilder();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(st.nextToken());
        }
        t = sb.toString();

        sb = new StringBuilder();
        go(0, sb);
    }

    public static void go(int depth, StringBuilder sb) {
        if (depth == 2) {
            int fk = sb.charAt(0) - '0', sk = sb.charAt(1) - '0';

            list = new LinkedList<>();
            for (int i = 0; i < n; i++)
                list.add(i + 1);
            // k를 중복조합으로 뽑아서 돌려야 된다는 건 파악 완료!
            mix(fk);
            mix(sk);

            for (int l : list) {
                res.append(l);
            }

            if (!t.contentEquals(res)) res.setLength(0); // 정답이 아니다. -> sb 비우는 테크닉
            else {
                System.out.println(fk + " " + sk);
                System.exit(0); // 정답나오자마자 재귀 완전히 끝내버리기
            }

            return;
        }

        for (int i = 1; i < n; i++) {
            if ((int) Math.pow(2, i) < n) {
                sb.append(i);
                go(depth + 1, sb);
                sb.deleteCharAt(sb.length() - 1);
//                sb.delete(sb.length() - 1, sb.length()); // 원복
            }
        }
    }

    public static void mix(int k) {
        int cnt = (int) Math.pow(2, k); // 2^k

        step1(cnt);
        stepN(k, 2, k - 1, cnt);
    }

    public static void step1(int cnt) {
        while (cnt-- > 0) {
            int num = list.pollLast();
            list.addFirst(num);
        }
    }

    public static void stepN(int k, int i, int limit, int cards) {
        while (i <= k + 1) { // 이게 문제 조건이었음
            int cnt = (int) Math.pow(2, limit); // 직전에 맨 위로 올린 카드 더미 중 밑에서 2^K - i + 1개의 카드
            int top = cards - (int) Math.pow(2, limit); // 카드 더미 위에 있는
            int bottom = list.size() - cards; // 카드 더미 아래 있는

            LinkedList<Integer> tl = new LinkedList<Integer>();
            LinkedList<Integer> bl = new LinkedList<Integer>();

            while (top-- > 0)
                tl.add(list.poll()); // 앞에서 빼기
            while (bottom-- > 0)
                bl.add(list.pollLast());
            // 뒤에서 빼기 1 2 3 4 5  -> 3이 기준이면 5 4 가 저장되고, 4 5 가 뽑혀나온다. 원래 순서대로 감

            while (!tl.isEmpty()) {
                list.add(tl.poll());
            }
            while (!bl.isEmpty()) {
                list.add(bl.pollLast());
            }
            //변수값 갱신
            cards = cnt;
            i++;
            limit = k - i + 1;
        }
    }
}