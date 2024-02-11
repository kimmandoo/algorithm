import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] t;
	static int[] p;
	static int[] like;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		t = new ArrayList[n + 1]; // idx=1은 사장이니까 -1들어감.
		// -1 1 2 3 4
		// 1은 사장이니 직속 상사가 없으므로 -1
		// 2는 직원, 사장이 직속상사.
		p = new int[n + 1];
		like = new int[n + 1];
		int sajang = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			t[i] = new ArrayList<>();
		}
		for (int i = 2; i <= n; i++) {
			int sup = sc.nextInt(); // i번 직원의 상사가 tmp다.
			t[sup].add(i);
		}

		for (int i = 1; i <= m; i++) {
			int idx = sc.nextInt();
			int w = sc.nextInt();
			like[idx] += w;
		}

		f(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(like[i]).append(" ");
		}
		System.out.println(sb);
	}

	public static void f(int target) {
		for (int i = 0; i < t[target].size(); i++) {
			int child = t[target].get(i);
			like[child] += like[target];
			f(child);
		}
	}
}
