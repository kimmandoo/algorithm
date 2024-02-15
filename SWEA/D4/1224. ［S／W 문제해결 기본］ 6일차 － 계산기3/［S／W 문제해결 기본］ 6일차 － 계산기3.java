import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Stack;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int len = sc.nextInt();
			String input = sc.next();
			StringBuilder sb = new StringBuilder();
			Stack<Character> op = new Stack();
			for (int i = 0; i < len; i++) {
				char t = input.charAt(i);
				if (0 <= t - '0' && t - '0' < 10) { // 이건 숫자 0~9
					sb.append(t);
				} else {
					// 연산자 우선순위는 - + 같고 * / 가 높다
					// 뽑아야 될 경우 -> - +일 때 - + * /를 만나면 뽑아야됨.
					// * / 일 때 * / 를 만나면 뽑아야됨.
					if (t == '(') {
						op.push(t);
					}
					if (t == ')') {
						while (true) {
							if (op.peek() == '(')
								break;
							else
								sb.append(op.pop());
						}
						op.pop(); // ( 도 빼주기
					} else {
						if (!op.isEmpty()) {
							if (t == '*' || t == '/') {
								if (op.peek() == '+' || op.peek() == '-')
									op.push(t);
								else {
									while (true) { // 같거나 높은 우선순위가 아닐때 까지
										if (op.peek() == '*' || op.peek() == '/')
											sb.append(op.pop());
										else
											break;
									}
									op.push(t);
								}
							} else if (t == '-' || t == '+') {
								if (op.peek() == '(') {
									op.push(t);
								} else {
									while (!op.isEmpty()) { // 같거나 높은 우선순위가 아닐때 까지
										if (op.peek() == '(')
											break;
										else
											sb.append(op.pop());
									}
									op.push(t);
								}
							}
						} else {
							op.push(t);
						}
					}

				}
			}
			String postOrdered = sb.toString();
			Stack<Integer> po = new Stack();

			for (int i = 0; i < postOrdered.length(); i++) {
				char t = postOrdered.charAt(i);
				if (0 <= t - '0' && t - '0' < 10)
					po.push(Character.getNumericValue(t));
				else {
					int op2 = po.pop();
					int op1 = po.pop();
					int res = 0;

					switch (t) {
					case '+':
						po.push(op1 + op2);
						break;
					case '-':
						po.push(op1 - op2);
						break;
					case '*':
						po.push(op1 * op2);
						break;
					case '/':
						po.push(op1 / op2);
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + po.peek());
		}
	}
}