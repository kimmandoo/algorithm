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
        int n = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1]; // 맨처음도 이전과 비교할 수 있도록 +1개 더 많이 해준다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<=n; i++){
            // 일단 다 1로 초기화
            Arrays.fill(dp,1);
        }
        int prevMax = 1; // 왼쪽에 존재하는 애들 중에 가장 큰 거
        int[] input = new int[n+1];
        for(int i=1; i<=n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<i; j++){ // 내 기준 왼쪽에 있는 숫자까지 확인할 것
                if(input[i] > input[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = 0;
        for(int i=0; i<=n; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}