import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= idx; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			sb.append("Case #").append(i).append(": ").append(a + b).append("\n");
		}
		System.out.println(sb);
	}
}