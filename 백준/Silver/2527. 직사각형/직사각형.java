import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 4; i++) {
			// square 1
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int p1 = sc.nextInt();
			int q1 = sc.nextInt();

			// square 2
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int p2 = sc.nextInt();
			int q2 = sc.nextInt();

//			if ((p1 == x2 && ((q1 == y2 || y1 == q2)))) {
//				sb.append("c").append("\n");
//			} else if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
//				sb.append("d").append("\n");
//			} else if ((p1 == x2) || (p2 == x1) || (q1 == y2) || (q2 == y1)) {
//				sb.append("b").append("\n");
//			} else {
//				sb.append("a").append("\n");
//			}
			// 조건 분기가 엄청 많다. 특히 점으로 붙는 부분
			if (p1 < x2 || p2 < x1 || q1 < y2 || q2 < y1) {
                sb.append("d").append("\n");
            } else if (p1 == x2 && q1 == y2 || p1 == x2 && q2 == y1 || p2 == x1 && q1 == y2 || p2 == x1 && q2 == y1) {
                sb.append("c").append("\n");
            } else if (p1 == x2 || p2 == x1 || q1 == y2 || q2 == y1) {
                sb.append("b").append("\n");
            } else {
                sb.append("a").append("\n");
            }
		}
		System.out.println(sb.toString());

		sc.close();
	}
}