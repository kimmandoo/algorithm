import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Main {
	static List<Integer>[] tree; 
	
	static int[] p;
	static boolean[] v;
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		tree = new ArrayList[n+1];
		p = new int[n+1];
		v = new boolean[n+1];
		
		for(int i=0; i<n+1; i++) {
			tree[i] = new ArrayList<>();
		}
		for(int i=0; i<n-1; i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			tree[node1].add(node2);
			tree[node2].add(node1);
		}
		find(1); // 1이 루트니까 
		for(int i=2; i<=n; i++) {
			System.out.println(p[i]);
		}
	}
	
	public static void find(int node) {
		v[node] = true;
		for(int i=0; i<tree[node].size(); i++) {
			int child = tree[node].get(i);
			if(!v[child]) {
				 p[child] = node;
				 find(child);
			}
		}
	}
}