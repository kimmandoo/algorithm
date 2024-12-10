import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		Integer[] arr = new Integer[n];
		st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Collections.reverse(Arrays.asList(arr));
		for(int i=1; i<n; i++) {
			arr[i] += arr[i-1];
		}
		Collections.reverse(Arrays.asList(arr));
//		System.out.println(Arrays.toString(arr));
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			if(e == n) {
				sb.append(arr[s-1]).append("\n");
			}else {
				sb.append(arr[s-1]-arr[e]).append("\n");
			}
		}
		bw.write(sb+"");
		bw.flush();
	}
}