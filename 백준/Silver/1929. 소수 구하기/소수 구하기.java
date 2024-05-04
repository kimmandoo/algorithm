import java.io.*;
import java.util.*;
 
 
public class Main {
	public static boolean[] p;
	public static void main(String[] args) throws Exception {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		p = new boolean[N + 1];
		get_prime();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = M; i <= N; i++) {
			if(!p[i]) sb.append(i).append('\n');
		}
		System.out.println(sb);
	}
 
	public static void get_prime() {
		p[0] = p[1] = true;
		
		for(int i = 2; i <= Math.sqrt(p.length); i++) {
			if(p[i]) continue;
			for(int j = i * i; j < p.length; j += i) {
				p[j] = true;
			}
		}
	}
}