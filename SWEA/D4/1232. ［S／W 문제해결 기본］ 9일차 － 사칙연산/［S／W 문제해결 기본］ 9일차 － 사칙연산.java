import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class Solution {

	static class Node {
		String data; // 숫자랑 연산자 둘다 들어갈 수 있게
		Node l;
		Node r;

		public void setData(String data) {
			this.data = data;
		}

		public Node() {
			// NOTHING
		}

		public Node(String data) {
			l = null;
			r = null;
			this.data = data;
		}
	}

	static LinkedList<String> s;

	public static void opTraversal(Node p) {
		if (p.l == null && p.r == null) {
			// 리프노드
			return;
		}
		opTraversal(p.l);
		opTraversal(p.r);
		String d = p.data;
		int lData = Integer.parseInt(p.l.data);
		int rData = Integer.parseInt(p.r.data);
		if (d.equals("-")) {
			p.setData(String.valueOf(lData - rData));
		}
		if (d.equals("+")) {
			p.setData(String.valueOf(lData + rData));
		}
		if (d.equals("*")) {
			p.setData(String.valueOf(lData * rData));
		}
		if (d.equals("/")) {
			if (rData == 0) {
				p.setData(String.valueOf(0));
			} else {
				p.setData(String.valueOf(lData / rData));
			}
		}

	}

	public boolean isNum(char ascii) {
		if (ascii - '0' >= 0 && ascii - '0' <= 9) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
//		Scanner sc = new Scanner(System.in);
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = new LinkedList();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			Node[] tree = new Node[n + 1];
			for (int i = 1; i <= n; i++) {
				tree[i] = new Node();
			}
			// leaf 노드가 아니면 모두 연산자...
			// -> 자식이 있으면 연산자를 넣고, 그게 아니면 숫자 넣기
			for (int i = 0; i < n; i++) {
				String[] input = br.readLine().split(" ");
				int node = Integer.parseInt(input[0]);
				String data = input[1];
				tree[node].setData(data);
				if (input.length == 3) {
					tree[node].l = tree[Integer.parseInt(input[2])];
				}
				if (input.length == 4) {
					tree[node].l = tree[Integer.parseInt(input[2])];
					tree[node].r = tree[Integer.parseInt(input[3])];
				}
			}
			opTraversal(tree[1]);
			System.out.println("#" + test_case + " " + tree[1].data);
		}
	}
}