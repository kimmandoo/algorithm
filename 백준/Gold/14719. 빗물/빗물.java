import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken()); // 세로 크기
        int W = Integer.parseInt(st.nextToken()); // 가로 크기

        int[] heights = new int[W]; // 블록의 높이 배열
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        // 왼쪽에서 본 최대 높이 계산
        leftMax[0] = heights[0];
        for (int i = 1; i < W; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], heights[i]);
        }

        // 오른쪽에서 본 최대 높이 계산
        rightMax[W - 1] = heights[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], heights[i]);
        }

        // 빗물이 고일 수 있는 양 계산
        int water = 0;
        for (int i = 0; i < W; i++) {
            // 고일 수 있는 물의 양은 좌우에서 본 최대 높이 중 더 작은 값에서 현재 기둥의 높이를 뺀 값
            int minHeight = Math.min(leftMax[i], rightMax[i]);
            if (minHeight > heights[i]) {
                water += minHeight - heights[i];
            }
        }

        System.out.println(water);
    }
}