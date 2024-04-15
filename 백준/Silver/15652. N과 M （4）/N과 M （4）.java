import java.util.*;
import java.io.*;

class Main {
	static int n;
	static int p;
	static StringBuilder sb;
	static List<Integer> list;

	public static void go(int x) {
		if (list.size() == p) {
			StringBuilder tmp = new StringBuilder();
		
			for (int i = 0; i < p - 1; i++) {
				if (list.get(i) > list.get(i + 1)) {
					return;
				}
			}
			
			for (int i = 0; i < p; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 1; i <= n; i++) {
			list.add(i);
			go(i + 1);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		p = Integer.parseInt(st.nextToken());
		list = new ArrayList();
		sb = new StringBuilder();
		go(1);
		System.out.println(sb);
	}
}