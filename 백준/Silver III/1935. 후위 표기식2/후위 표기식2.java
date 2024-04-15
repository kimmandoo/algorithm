import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String input = sc.next();
		Stack<Double> s = new Stack<>();
		double[] abc = new double[26];
		for (int i = 0; i < n; i++) {
			abc[i] = sc.nextDouble();
		}
		for (int i = 0; i < input.length(); i++) {
			char tmp = input.charAt(i);
			if ('A' <= tmp && tmp <= 'Z') {
				s.push(abc[tmp - 'A']);
			} else {
				double op2 = s.pop();
				double op1 = s.pop();
				switch (tmp) {
				case '*':
					s.push(op1 * op2);
					break;
				case '/':
					s.push(op1 / op2);
					break;
				case '+':
					s.push(op1 + op2);
					break;
				case '-':
					s.push(op1 - op2);
					break;
				}
			}
		}
		System.out.printf("%.2f", s.peek());

		sc.close();
	}
}