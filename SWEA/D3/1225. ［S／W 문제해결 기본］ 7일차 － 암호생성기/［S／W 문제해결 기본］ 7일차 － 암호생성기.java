import java.util.*;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
//		System.setIn(new FileInputStream("input"));

		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int t = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			LinkedList<Integer> dq = new LinkedList();
			for (int tc = 0; tc < 8; tc++) {
				dq.offer(sc.nextInt());
			}
			int laps = 1;
			while (true) {
				if (laps == 6)
					laps = 1;

				if (dq.peekFirst() - laps <= 0) {
//					System.out.println("last:"+dq.peekFirst()+" laps:"+laps);
					dq.pop();
					dq.offerLast(0);
					break;
				} else {
					dq.offerLast(dq.pollFirst() - laps);
				}
				laps++;
			}
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < 8; i++) {
				sb.append(dq.pollFirst()).append(" ");
			}

			System.out.println(sb);
		}
	}
}