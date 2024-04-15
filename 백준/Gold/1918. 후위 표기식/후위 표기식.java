import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		StringBuilder sb = new StringBuilder();
		Stack<Character> op = new Stack();
		for (int i = 0; i < input.length(); i++) {
			char t = input.charAt(i);
			if ('A' <= t && t <= 'Z') {
				sb.append(t);
			} else {
				// 연산자 우선순위는 - + 같고 * / 가 높다
				// 뽑아야 될 경우 -> - +일 때 - + * /를 만나면 뽑아야됨.
				// * / 일 때 * / 를 만나면 뽑아야됨.
				if (t == '(') {
					op.push(t);
				}
				if (t == ')') {
					while (!op.isEmpty()) {
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
					                if (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/'))
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
		while (!op.isEmpty()) {
			sb.append(op.pop());
		}
		System.out.println(sb);

	}
}