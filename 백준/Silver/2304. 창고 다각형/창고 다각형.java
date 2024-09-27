import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int maxH = -1;
        int maxIdx = -1;
        int[] input = new int[10001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int idx = Integer.parseInt(st.nextToken()); // 기둥 왼쪽면의 위치
            int h = Integer.parseInt(st.nextToken());
            input[idx + 1] = h; // idx 자체는 0이 없으나, 0-1 ,1-2 이렇게 간격으로 들어감 -> 정확히는 왼쪽 모서리 기준이니까 하나씩 밀기
            maxIdx = Math.max(idx, maxIdx);
            maxH = Math.max(h, maxH);
        }


        int[] pref = new int[maxIdx + 2]; // 앞뒤에 한칸씩 추가하기
        int[] suff = new int[maxIdx + 2]; // 앞뒤에 한칸씩 추가하기
        int[] maxPoint = new int[2]; //
        Arrays.fill(maxPoint, -1);
        int prev = 0;
        int prefSum = -1;
        int suffSum = -1;
        // l to r
        for (int i = 1; i <= maxIdx + 1; i++) {
            prev = Math.max(input[i], prev);
            pref[i] = pref[i - 1] + prev;
            if (input[i] == maxH) {
                maxPoint[0] = i;
                break;
            }
        }
        prev = 0;
        for (int i = maxIdx + 1; i >= 0; i--) {
            prev = Math.max(input[i], prev);
            suff[i - 1] = suff[i] + prev;
            if (input[i] == maxH) {
                maxPoint[1] = i;
                break;
            }
        }
        // max까지 합
        int maxLToR = -1;
        int maxRToL = -1;
        for (int i = 0; i < maxPoint[0]; i++) {
            maxLToR = Math.max(maxLToR, pref[i]);
        }
        for (int i = maxIdx + 1; i >= maxPoint[1]; i--) {
            maxRToL = Math.max(maxRToL, suff[i]);
        }
//        System.out.println(maxLToR + ", " + maxRToL);

        // 합치기

        int maxWidth = maxPoint[1] - maxPoint[0] + 1;

//
//        System.out.println(Arrays.toString(pref) + ", " + maxPoint[0] + ", " + maxH);
//        System.out.println(Arrays.toString(suff) + ", " + maxPoint[1] + ", " + maxH);
        System.out.println(maxLToR + maxRToL + maxWidth * maxH);
    }
}
