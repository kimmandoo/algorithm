import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int n;
    static int[] present;
    static boolean[] v;
    static int[] cnt = new int[4];
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken()); // n 개의 선물
        present = new int[n];
        v = new boolean[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            cnt[Integer.parseInt(st.nextToken())]++; // cnt 배열
        }
        int ans = 0;
        // 0~3 사이의 수가 XOR했을 때 항상 최대가 되는 조함
        // 0과 3 매칭 0^3 = 3
        int pairs = Math.min(cnt[0], cnt[3]);
        ans += 3 * pairs;
        cnt[0] -= pairs; // 쌍만큼 뻄
        cnt[3] -= pairs;

        // 1과 2 매칭 1^2 = 3
        pairs = Math.min(cnt[1], cnt[2]);
        ans += 3 * pairs;
        cnt[1] -= pairs;
        cnt[2] -= pairs;

        // 남은 수들 (최대 값 쌍 미리 다 뺴고)
        for(int i = 0; i < 4; i++) {
            for(int j = i+1; j < 4; j++) {
                pairs = Math.min(cnt[i], cnt[j]);
                ans += (i ^ j) * pairs; // i^j가 1이거나, 0일 수 도 있으니까 연산식 넣기
                cnt[i] -= pairs;
                cnt[j] -= pairs;
            }
        }

        System.out.println(ans);
    }


    public static int go(int idx, int now) { // n이 20만이라 재귀 절대 안된다.
        if (idx * 2 == n) {
            // 고양이 다 매칭
            return now; // 끝까지 갔을 때 만족도
        }
        int max = -1;
        for (int i = idx; i < n; i++) {
            if (v[i]) continue;
            for (int j = i + 1; j < n; j++) {
                if (!v[j]) { // 두 순서쌍 모두 사용안한경우에
                    v[i] = v[j] = true;
                    max = Math.max(go(idx + 1, now + (present[i] ^ present[j])), max); // 다음 고양이로
                    // return 이 나온다는건 끝 고양이까지 갔다는 의미. -> max 값 비교가 된다.
                    v[i] = v[j] = false;
                }
            }
        }
        // for문을 다 돌면 모든 경우를 찾은거니까 max 반환해도 된다.
        return max;
    }
}