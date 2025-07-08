import java.util.*;

class Solution {
    public int solution(int n, int[] l, int[] r) {
        Arrays.sort(l);
        Arrays.sort(r);
        boolean[] useR = new boolean[r.length];
        boolean[] useL = new boolean[l.length];

        // lost와 reserve에 모두 있는 사람 먼저 제외
        for (int i = 0; i < l.length; i++) {
            for (int j = 0; j < r.length; j++) {
                if (!useL[i] && !useR[j] && l[i] == r[j]) {
                    useL[i] = true;
                    useR[j] = true;
                    break;
                }
            }
        }

        int answer = n;
        
        // 빌릴 수 있는 경우 처리
        for (int i = 0; i < l.length; i++) {
            if (useL[i]) continue; // 이미 처리된 사람은 패스

            boolean borrowed = false;
            for (int j = 0; j < r.length; j++) {
                if (!useR[j] && Math.abs(l[i] - r[j]) == 1) {
                    useR[j] = true;
                    borrowed = true;
                    break;
                }
            }

            if (!borrowed) answer--; // 못 빌렸으면 체육복 없음
        }

        return answer;
    }
}