import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	static class Node {
		char data;
		Node l;
		Node r;

		public void setData(char data) {
			this.data = data;
		}

		public Node() {
		}

		public Node(char data) {
			this.data = data;
			l = null;
			r = null;
		}
	}

	static int[] v;
	static char[] p;

	public static void inorder(Node p) {
		if (p.l != null) {
			inorder(p.l);
		}
		System.out.print(p.data);
		if (p.r != null) {
			inorder(p.r);
		}
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			Node[] tree = new Node[n + 1];
			v = new int[n + 1];

			for (int i = 0; i <= n; i++) {
				tree[i] = new Node();
			}

			int idx = 1;
			for (int i = 0; i < n; i++) {
				// 1 W 2 3
				int node = sc.nextInt();
				tree[node].setData(sc.next().charAt(0));
				
				if (idx < n) {
					int l = sc.nextInt();
					idx++;
					tree[node].l = tree[l];
				}
				if (idx < n) {
					int r = sc.nextInt();
					idx++;
					tree[node].r = tree[r];
				}
			}
			System.out.print("#" + test_case + " ");
			inorder(tree[1]);
			System.out.println();
		}
	}
}