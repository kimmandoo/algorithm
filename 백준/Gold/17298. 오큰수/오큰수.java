import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        Stack<Integer> s = new Stack<>();

        for(int i=0;i<n; i++){
            while(!s.empty() && input[s.peek()] < input[i]) {
                input[s.pop()] = input[i];
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            input[s.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(input[i]).append(' ');
        }

        System.out.println(sb);
    }
}