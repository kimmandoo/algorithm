import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int l, r, c;
    static char[][][] map;
    static boolean[][][] v;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};
    static int sf, si, sj;
    static StringBuilder sb;

    static class Node {
        int f, i, j, t;

        Node(int f, int i, int j, int t) {
            this.f = f;
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine(), " ");
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            map = new char[l][r][c];
            v = new boolean[l][r][c];
            if (l == 0 && r == 0 && c == 0) {
                break;
            }
            // 지나갈 수 없는 칸은 '#', 비어있는 칸은 '.', 시작 지점은 'S', 출구는 'E'

            for (int f = 0; f < l; f++) {
                for (int i = 0; i < r; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < c; j++) {
                        map[f][i][j] = line.charAt(j);
                        if (line.charAt(j) == 'S') {
                            sf = f;
                            si = i;
                            sj = j;
                        }
                    }
                }
                br.readLine(); // 빈줄 처리
            }
            go();
//            for (char[][] m : map) {
//                for (int i = 0; i < r; i++) {
//                    System.out.println(Arrays.toString(m[i]));
//                }
//                System.out.println();
//            }
        }
        System.out.println(sb);
    }

    public static void go() {
        LinkedList<Node> pq = new LinkedList<>();
//        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
//            return o1.t - o2.t;
//        });
        // 시간 기준으로 minHeap;
        pq.offer(new Node(sf, si, sj, 0));
        v[sf][si][sj] = true;
        boolean find = false;
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cf = now.f;
            int ci = now.i;
            int cj = now.j;
            int ct = now.t;
            if (map[cf][ci][cj] == 'E') {
                find = true;
                sb.append("Escaped in ").append(ct).append(" minute(s).").append("\n");
                //Escaped in 11 minute(s).
                //Trapped!
                break;
            }
            for (int d = 0; d < 6; d++) {
                // 4방 탐색, + 상하
                if (d < 4) {
                    int ni = di[d] + ci;
                    int nj = dj[d] + cj;
                    if (check4(cf, ni, nj) && (map[cf][ni][nj] == '.' || map[cf][ni][nj] == 'E')) {
                        v[cf][ni][nj] = true; // 방문처리하고
                        pq.offer(new Node(cf, ni, nj, ct + 1)); // 움직였으니까 1분 추가
                    }
                }
                if (d == 4) {
                    int nf = cf + 1;
                    if (check2(nf, ci, cj) && (map[nf][ci][cj] == '.' || map[nf][ci][cj] == 'E')) {
                        v[nf][ci][cj] = true;
                        pq.offer(new Node(nf, ci, cj, ct + 1));
                    }
                }
                if (d == 5) {
                    int nf = cf - 1;
                    if (check2(nf, ci, cj) && (map[nf][ci][cj] == '.' || map[nf][ci][cj] == 'E')) {
                        v[nf][ci][cj] = true;
                        pq.offer(new Node(nf, ci, cj, ct + 1));
                    }
                }
            }
        }
        if (!find) sb.append("Trapped!").append("\n");
    }

    public static boolean check4(int cf, int ci, int cj) {
        return ci < r && cj < c && ci >= 0 && cj >= 0 && !v[cf][ci][cj]; // 방문안했으면
    }

    public static boolean check2(int cf, int ci, int cj) {
        return cf >= 0 && cf < l && !v[cf][ci][cj]; // 방문안했으면
    }
}