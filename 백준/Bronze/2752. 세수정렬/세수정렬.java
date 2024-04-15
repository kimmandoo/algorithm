import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); // 원본을 참조하고 있음
        bw.write(String.valueOf(arr[0]));
        bw.write(" "+arr[1]);
        bw.write(" "+arr[2]);
        bw.flush();
        bw.close();
        br.close();
    }
}