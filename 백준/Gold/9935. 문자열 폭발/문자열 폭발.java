import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String bomb = br.readLine();
        System.out.println(go(s, bomb));
    }

    public static String go(String input, String bomb) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            sb.append(input.charAt(i));
            while (sb.length() >= bomb.length()) {
                if (sb.substring(sb.length() - bomb.length()).equals(bomb)) {
                    // 뒤에 bomb 길이만큼 잘랐을 때 같으면
                    sb.delete(sb.length() - bomb.length(), sb.length()); // [ )
                } else break;
            }
        }
        if (sb.toString().isEmpty()) return "FRULA";
        else return sb.toString();
    }
}