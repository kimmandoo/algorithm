import java.util.Scanner;
import java.util.*;

public class Main {
	static List<Integer>[] tree;
	static int[] p;
	static boolean[] v;
/** 
 * 두번째 풀이가 틀린이유
 * 일단 양방향으로 처리하지않았음
 * 부모 노드에 자식노드 추가할 때 자식노드도 부모노드를 추가하고 있어야됨. p는 부모노드값을 넣어둔 배열이다.
 * 방문 배열도 만들어두고, 중복해서 재귀가 돌지 않도록 넣는다.
 */
	public static void treeBfs(int cur) {
		v[cur] = true;
		for (int i = 0; i < tree[cur].size(); i++) {
			int child = tree[cur].get(i);
			if (!v[child]) {
				p[child] = cur; // cur이 child의 부모노드다.
				treeBfs(child);
			}
		}
//		if (tree[cur] == null) {
//			// 자식 노드이자 leaf 노드라는 소리
//			return;
//		} else {
//			System.out.println(cur);
//			for (int i = 0; i < tree[cur].size(); i++) {
//				treeBfs(tree[cur].get(i));
//			}
//		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tree = new ArrayList[n + 1]; // tree[1]부터 시작할 것.
		p = new int[n + 1];
		v = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			tree[i] = new ArrayList<>(); // null 참조 안하게 일단 생성하기
		}

		for (int i = 1; i < n; i++) {
			int parent = sc.nextInt();
			int child = sc.nextInt();
			tree[parent].add(child);
			tree[child].add(parent); // 이걸 해야 자식 노드가 부모노드를 찾아간다. 
		}
		treeBfs(1);
		for(int i=2; i<=n; i++) {
			System.out.println(p[i]+" ");
		}
	}
}