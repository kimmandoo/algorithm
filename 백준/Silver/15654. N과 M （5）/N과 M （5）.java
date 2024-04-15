import java.util.*;

public class Main {

	static int n, m; // 함수 안에서도 사용할 수 있게
	static int[] numbers;
	static boolean[] check;
	static int[] output;

	public static void perm(int depth) {
		// base case
		if (depth == m) {
			// 원하는 만큼 뽑았다
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < m; i++) {
				sb.append(output[i]).append(" ");
			}
			System.out.println(sb);
			return; // 이게 중요함. 더이상 안뽑아도 되니까 함수를 종료시켜야됨.
		}
		// recursive case
		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				// 한번도 안썼다면
				check[i] = true;
				output[depth] = numbers[i]; // 현재 뎁스에서 저장해야됨.
				perm(depth + 1);
				check[i] = false; // 함수 호출 이후로는 다른 case도 사용해야되니까 check에 다시 false를 넣는다.
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		numbers = new int[n];
		check = new boolean[n];
		output = new int[m];

		for (int i = 0; i < n; i++) {
			numbers[i] = sc.nextInt();
		}

		Arrays.sort(numbers);
		perm(0); // depth는 0 부터 시작한다.
	}
}