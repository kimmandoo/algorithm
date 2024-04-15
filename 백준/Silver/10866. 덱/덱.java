import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = sc.next();
            switch (input) {
                case "push_back": {
                    int item = sc.nextInt();
                    dq.addLast(item);
                    break;
                }
                case "push_front": {
                    int item = sc.nextInt();
                    dq.addFirst(item);
                    break;
                }
                case "front":
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "back":
                    if (!dq.isEmpty()) {
                        sb.append(dq.peekLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "size":
                    sb.append(dq.size()).append("\n");
                    break;
                case "empty":
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "pop_front":
                    if (!dq.isEmpty()) {
                        sb.append(dq.pollFirst()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
                case "pop_back":
                    if (!dq.isEmpty()) {
                        sb.append(dq.pollLast()).append("\n");
                    } else {
                        sb.append(-1).append("\n");
                    }
                    break;
            }
        }
        System.out.print(sb);
    }
}