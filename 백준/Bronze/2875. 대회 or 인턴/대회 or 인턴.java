import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/boj.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int team = 0;

        // 팀을 만들 수 있는 조건을 계속 확인하며 반복
        while (n >= 2 && m >= 1 && (n + m - 3) >= k) {
            team++;

            // 팀에 참여한 학생 수를 뺀다
            n -= 2; // 여학생 2명 감소
            m -= 1; // 남학생 1명 감소
        }

        System.out.println(team);
    }
}