import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        sb = new StringBuilder();
        arr = new LinkedList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // n까지의 자연수로 길이가 m인 수열 만들기
        go(0);
        System.out.println(sb);
    }

    static LinkedList<Integer> arr;
    public static void go(int k) {
        if(k == m){
            // sb에 추가하기
            for(int i=0; i<k;i++){
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            // 중복을 제거한다
            if(arr.contains(i)) continue;
            arr.addLast(i);
            go(k+1); // k는 자리수를 의미함
            arr.removeLast();
        }
    }
}
