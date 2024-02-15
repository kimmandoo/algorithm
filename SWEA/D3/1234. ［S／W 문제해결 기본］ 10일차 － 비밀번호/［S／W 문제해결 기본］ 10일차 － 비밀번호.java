import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = sc.nextInt();
			String target = sc.next();
			// 10 1238099084
			Stack<Integer> reverse = new Stack();
			for (int i = 0; i < n; i++) {
				int tmp = Character.getNumericValue(target.charAt(i));
				if (!reverse.isEmpty() && reverse.peek() == tmp) {
					reverse.pop();
				} else {
					reverse.push(tmp);
				}
			}
			int rs = reverse.size();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < rs; i++) {
				sb.append(reverse.pop());
			}

			System.out.println("#" + test_case + " " + sb.reverse());
		}
	}
}