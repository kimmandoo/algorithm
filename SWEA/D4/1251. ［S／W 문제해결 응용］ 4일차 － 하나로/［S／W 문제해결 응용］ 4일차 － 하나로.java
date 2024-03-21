import java.util.*;
import java.io.*;

public class Solution {
	static int[] p;
	static int n;

	static void make() {
		p = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			p[i] = i;
		}
	}

	static int find(int a) {
		if (p[a] == a)
			return a;
		return p[a] = find(p[a]);
	}

	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == pb) {
			// 합쳐지면 사이클을 이루게 되는 경우
			return false;
		}
		p[pb] = pa;
		return true;
	}

	static class Edge { // 두 좌표간 from to니까 2차원 배열 써야됨
		int from, to;
		double w;

		Edge(int from, int to) {
			this.from = from;
			this.to = to;
		}

		void setWeight(double w) {
			this.w = w;
		}
	}

	static double w(double E, int x1, int y1, int x2, int y2) {
		double weight = ((double) Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2)) * E;
		return weight;
	}

	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken()); // 섬 개수
			ArrayList<Edge> e = new ArrayList<Edge>();
			StringTokenizer x = new StringTokenizer(br.readLine(), " ");
			StringTokenizer y = new StringTokenizer(br.readLine(), " ");

			int[][] cor = new int[n][2];

			for (int i = 0; i < n; i++) {
				int cx = Integer.parseInt(x.nextToken());
				int cy = Integer.parseInt(y.nextToken());
				cor[i][0] = cx;
				cor[i][1] = cy;
			}

			// 이제 cor에는 모든 좌표가 저장되어 있음 -> 이거로 모든 간선 만들면 됨
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					e.add(new Edge(i, j));
					e.add(new Edge(j, i));
				}
			}
			// 좌표로 준거로 모든 간선 생성
			st = new StringTokenizer(br.readLine(), " ");
			double energy = Double.parseDouble(st.nextToken());

			// 이제 각 간선의 모든 가중치 저장
			for (int i = 0; i < e.size(); i++) {
				e.get(i).w = w(energy, cor[e.get(i).from][0], cor[e.get(i).from][1], cor[e.get(i).to][0],
						cor[e.get(i).to][1]);
			}

			// 가중치 넣기 완료 -> 이제 오름차순 정렬하자
			Collections.sort(e, new Comparator<Edge>() {
				@Override
				public int compare(Edge o1, Edge o2) {
					// TODO Auto-generated method stub
					if (o1.w < o2.w) {
						return -1;
					} else if (o1.w == o2.w) {
						return 0;
					} else {
						return 1;
					}
				}
			});

			int cnt = 0;
			double acc = 0;
			make();
			for (int i = 0; i < e.size(); i++) {
				if (cnt == n)
					break;
				if (union(e.get(i).from, e.get(i).to)) {
					// union이 false를 내뱉을 때 -> 같은 부모를 두고 있을 때
					acc += e.get(i).w;
					cnt++;
//					System.out.println(e.get(i).from + ", " + e.get(i).to + "| " + e.get(i).w);
				}
			}

//			System.out.println(Arrays.toString(p));

			sb.append("#").append(test_case).append(" ").append(String.format("%.0f", acc)).append("\n");
		}

		System.out.println(sb);
	}
}