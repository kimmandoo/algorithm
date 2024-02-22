import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class Solution {
	static int min;
	static int d;
	static int M;
	static int M3;
	static int[] month;
	static char[] output;
	static char[] billingCase;
	// 중복순열이라 이게 필요할 지는 잘 모르겠음.

	public static void perm(int depth) {
		if (depth == output.length) {
			// depth 만큼 다 찾았다.
			int idx = 0;
			int sum = 0;
			int i = 0;
			while (i < 12) {
				if (month[i] > 0) {
					// 3개월 권은 지금 달에서 3개월 후 ex) 1월달에 3개월 권 끊으면 3월까지 유지 1,2,3고 [4]로 i이동시키면됨.
					if (output[idx] == 'd') {
						sum += month[i] * d;
						idx++;
						i++;
					} else if (output[idx] == 'M') {
						sum += M;
						idx++;
						i++;
					} else if (output[idx] == '3') {
						sum += M3;
						idx += 2;
						i += 3;
					}
				}else {
					i++;
				}
			}
			min = Math.min(min, sum);
//			System.out.println(Arrays.toString(output) + " : " + sum + " : " + min);
		} else {
			for (int i = 0; i < billingCase.length; i++) {
				// 방문체크를 할 필요가 없다.
				output[depth] = billingCase[i];
				perm(depth + 1);
			}
		}
	}

	public static void main(String args[]) throws Exception {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
//		int T = 1;

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			min = Integer.MAX_VALUE;
			// 1일, 1달, 3달, 1년 이용권의 각각 값
			d = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			M3 = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			month = new int[12];
			billingCase = new char[] { 'd', 'M', '3' };
			st = new StringTokenizer(br.readLine());
			// 각 달의 이용계획
			int valid = 0;
			for (int i = 0; i < 12; i++) {
				month[i] = Integer.parseInt(st.nextToken());
				if (month[i] != 0) {
					valid++;
				}
			}
			output = new char[valid];
			perm(0);
			min = Math.min(min, year);

//			// 가장 적은 비용으로 이용할 수 있는 경우의 수 계산
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(min).append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
	}
}