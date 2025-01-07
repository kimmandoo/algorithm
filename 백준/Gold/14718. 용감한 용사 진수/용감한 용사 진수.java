import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int n, k;
    public static int[][] soldier;
    public static int minStat = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        soldier = new int[n][3]; // 힘, 민첩, 지능

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            soldier[i][0] = Integer.parseInt(st.nextToken());
            soldier[i][1] = Integer.parseInt(st.nextToken());
            soldier[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int d = 0; d < n; d++) {
                    int cnt = 0;
                    for (int q = 0; q < n; q++) {
                        if (soldier[i][0] >= soldier[q][0] && soldier[j][1] >= soldier[q][1] && soldier[d][2] >= soldier[q][2]) {
                            cnt++;
                        }
                    }

                    if (cnt >= k) minStat = Math.min(minStat, soldier[i][0] + soldier[j][1] + soldier[d][2]);
                }
            }
        }

        System.out.println(minStat);
    }
}