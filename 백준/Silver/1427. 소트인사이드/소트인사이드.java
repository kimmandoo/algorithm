import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = s.length();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.charAt(i)-'0';
        }
        Arrays.sort(arr, Collections.reverseOrder());  //내림차순으로 정렬
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}