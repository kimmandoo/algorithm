import java.util.*;
import java.io.*;

public class Main {
	static int[] p;
	static int n;

	public static void make() {
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
	}

	public static int find(int a) { // 보스 찾기
		if (p[a] == a) {
			return a; // 보스가 나일때 끝
		}
		return p[a] = find(p[a]); // 보스 경로 압축
	}

	public static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb)
			return false; // 보스가 같으면 union 하지 않는다. -> 사이클을 돈다는 얘기
		p[pb] = pa; // pb의 보스에 a의 보스를 넣는 것 -> 같은 집합에 넣는다는 말
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		p = new int[n]; // 정점은 0부터 N-1까지
		int res = 0;
		make();
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (!union(a, b)) {
				res = i;
				break;
			}
		}

		StringBuilder sb = new StringBuilder();
		sb.append(res);

		System.out.println(sb);
	}
}