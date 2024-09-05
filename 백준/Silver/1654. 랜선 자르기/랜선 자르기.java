import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] lan;

    static long parametric() {
        long left = 1; // 랜선 길이는 1부터 시작한다.
        long right = lan[k-1];
        long result = 0;

        while (left <= right) {
            long mid = (left + right) / 2; // 가장 큰 길이랑 반으로 쪼개기
            long count = 0;

            for (int cable : lan) {
                count += cable / mid; // 쪼개는 데 성공하면(몫이면) 그만큼 자를 수 있다는 얘기
            }

            if (count >= n) { // n보다 크거나 같으면 더 자를 수 있다는 얘기
                result = mid; // 만약 여기서 탈출한다면 n개에 맞춰진 것
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }


    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        k = Integer.parseInt(st.nextToken()); // 이미 갖고있는 랜선 개수
        n = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수
        lan = new int[k];
        // 랜선 길이가 Int를 넘어간다 -> long으로
        // k개의 랜선에서 n개의 같은 길이 랜선을 만들어야됨
        // n개의 같은 길이 랜선을 만들 때, 가장 랜선 길이가 길 경우
        for (int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lan); // 이분탐색을 수행하기 위해 정렬(오름차순)
        System.out.println(parametric());
    }
}