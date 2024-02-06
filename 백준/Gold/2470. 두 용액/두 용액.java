import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] input;
    public static int bi(int s, int e, int target){
        int min = input[s];
        int minAbs = Math.abs(target + min);
        int l = s+1; int r = e; // 고른 건 빼야되니까
        while (l<=r){
            int m = (l+r)/2;
            int sum = target + input[m];
            int sumAbs = Math.abs(sum);// 이제 이게 이분탐색 기준점이 됨
            if(sumAbs < minAbs){ // 더 작은 거로 이동해야 0에 가까워진다.
                min = input[m];
                minAbs = sumAbs;
            }
            if(sum<0){ // sum이 음수면 왼쪽을 볼 필요가 없다.
                l = m+1;
            }else if (sum >0){
                r = m-1; // sum이 양수면 오른쪽을 볼 필요가 없다.
            }else{
                return input[m];
            }
        }
        return min;
    }

    public static void main(String[] args) throws Exception {
//        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);
        int ansAbs = Math.abs(input[0]+input[1]);
        int ans1 = input[0];
        int ans2 = input[1];
        for(int i=0; i<n-1; i++){
            int min = bi(i+1,n-1, input[i]);
            int sumAbs = Math.abs(min+input[i]);
            if(ansAbs > sumAbs){
                ansAbs = sumAbs;
                ans1 = input[i];
                ans2 = min;
            }
        }
        System.out.println(ans1+" "+ans2);

    }
}
