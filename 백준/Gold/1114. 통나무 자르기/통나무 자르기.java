import java.io.*;
import java.util.*;

public class Main {
    static int L, k, c;
    static int[] cut;

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken()); // 최대 c번 자른다

        cut = new int[k + 2]; // 시작점 끝점 포함
        cut[0] = 0;
        cut[k + 1] = L;

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= k; i++) {
            cut[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cut);

        int[] res = go();
        System.out.println(res[0] + " " + res[1]);
    }

    // 가능한 최대 통나무 길이의 최소값 찾기
    public static int[] go() {
        int l = 1;
        int r = L;
        int len = L;  // 정답후보
        int idx = 0;  // 정답일 때 위치

        while (l <= r) {
            int m = (l + r) / 2;

            int[] res = check(m);

            if (res[0] == 1) {  // 자르기가 가능한 경우
                len = m;        // 현재 길이를 정답 후보로 저장
                idx = res[1];     // 첫 자르는 위치도 저장
                r = m - 1; // 작은거도 되나 봐야지
            } else {            // 자르기가 불가능한 경우
                l = m + 1;    // 더 큰 길이 시도
            }
        }

        return new int[]{len, idx};
    }

    public static int[] check(int maxLen) {
        // 먼저 연속된 두 지점 사이의 거리 체크
        for (int i = 1; i <= k + 1; i++) {
            if (cut[i] - cut[i-1] > maxLen) {
                return new int[]{0, 0};
            }
        }

        int cnt = 0;
        int last = k + 1;  // 마지막으로 자른 위치의 인덱스 -> k+1은 사실상 전체 길이를 의미함

        // 뒤에서부터 앞으로 오면서 통나무를 자름
        for (int i = k; i >= 0; i--) {
            // 이전 조각 - 지금 위치 = 지금 조각인데 큰거부터 자르기 시작하기
            if (cut[last] - cut[i] > maxLen) {
                // 첫 조각이 maxLen보다 크면 불가능
                if (i == k) return new int[]{0, 0};
                cnt++;
                last = i + 1;
                i++;  // 현재 위치 다시 검사 -> 똑같은 조각으로 또 자르는 것이다.
            }
        }

        if (cnt > c) return new int[]{0, 0}; // 1은 자른거, 0은 못자르는 거

        // 첫 번째 자르는 위치 결정하기
        if (cnt < c) { // 최대 c니까 이래도 됨
            // 자를 수 있는 횟수가 남았다면, 가장 앞에서 자름
            return new int[]{1, cut[1]};
        } else {
            return new int[]{1, cut[last]};
        }
    }
}