import java.util.Scanner;
import java.io.FileInputStream;
import java.util.*;
import java.io.*;

class Solution {
	static char[] opers;
	static boolean[] check;
	static char[] output;
	static int min;
	static int max;
	static int[] numbers;

	public static void perm(int depth) {
		// base case
		if (depth == opers.length) {
//			for(int i=0; i<output.length; i++) {
//				System.out.print(output[i]+" ");
//			}
//			System.out.println();
			// 원하는 만큼 뽑았다
			// 연산하기
			int sum = numbers[0];
			int opIdx = 0;
			int numIdx = 1;
			for(int i=0; i< output.length; i++) {
				if (output[opIdx] == '+') {
					sum += numbers[numIdx++];
					opIdx++;
				} else if (output[opIdx] == '-') {
					sum -= numbers[numIdx++];
					opIdx++;
				} else if (output[opIdx] == '*') {
					sum *= numbers[numIdx++];
					opIdx++;
				} else if (output[opIdx] == '/') {
					sum /= numbers[numIdx++];
					opIdx++;
				}
			}
			
			min = Math.min(min, sum);
			max = Math.max(max, sum);

			return; // 이게 중요함. 더이상 안뽑아도 되니까 함수를 종료시켜야됨.
		}
		
		char prevOp = ' '; // 이전 연산자를 기록하기 위한 변수 추가
	    for (int i = 0; i < opers.length; i++) {
	        if (!check[i] && opers[i] != prevOp) { // 중복되지 않고 이전 연산자와 다른 경우에만 진행
	            // 한번도 안썼다면
	            check[i] = true;
	            output[depth] = opers[i]; // 현재 뎁스에서 저장해야됨.
	            perm(depth + 1);
	            check[i] = false; // 함수 호출 이후로는 다른 case도 사용해야되니까 check에 다시 false를 넣는다.
	            prevOp = opers[i]; // 현재 연산자를 이전 연산자로 설정
	        }
	    }
		
//		// recursive case
//		for (int i = 0; i < opers.length; i++) {
//			if (!check[i]) {
//				// 한번도 안썼다면
//				check[i] = true;
//				output[depth] = opers[i]; // 현재 뎁스에서 저장해야됨.
//				perm(depth + 1);
//				check[i] = false; // 함수 호출 이후로는 다른 case도 사용해야되니까 check에 다시 false를 넣는다.
//			}
//		}
	}

	public static void main(String args[]) throws Exception {
//		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
//		int T = 1;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine()); // 숫자배열
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			numbers = new int[n];
			// 연산자 우선순위는 고려하지않고 -> 방향으로 차례대로 연산한다.
			// 최솟값과 최댓값의 차를 반환하면 됨. -> 순열?
			int[] opCnt = new int[4];
			StringTokenizer st = new StringTokenizer(br.readLine());
			opCnt[0] = Integer.parseInt(st.nextToken());// +
			opCnt[1] = Integer.parseInt(st.nextToken());// -
			opCnt[2] = Integer.parseInt(st.nextToken());// *
			opCnt[3] = Integer.parseInt(st.nextToken());// /
			int cnt = opCnt[0] + opCnt[1] + opCnt[2] + opCnt[3];
			opers = new char[cnt];
			output = new char[cnt];
			check = new boolean[cnt];
			int idx = 0;
			for (int i = idx; i < opCnt[0]; i++) {
				opers[i] = '+';
				idx++;
			}
			for (int i = idx; i < opCnt[1] + opCnt[0]; i++) {
				opers[i] = '-';
				idx++;
			}
			for (int i = idx; i < opCnt[2] + opCnt[1] + opCnt[0]; i++) {
				opers[i] = '*';
				idx++;
			}
			for (int i = idx; i < opCnt[3] + opCnt[2] + opCnt[1] + opCnt[0]; i++) {
				opers[i] = '/';
				idx++;
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				// 순서대로 연산자 돌림
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			perm(0);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(max - min).append("\n");
			bw.write(sb.toString());
			bw.flush();
		}
	}
}
