import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)-> -Integer.compare(o1, o2));
		for(int i=0; i<n; i++) {
			int tmp = Integer.parseInt(br.readLine());
			if(tmp==0) {
				if(pq.isEmpty()) {
					sb.append("0").append("\n");
				}else {
					sb.append(pq.poll()).append("\n");
				}
			}else {
				pq.add(tmp);
			}
		}
		System.out.println(sb);
	}
}