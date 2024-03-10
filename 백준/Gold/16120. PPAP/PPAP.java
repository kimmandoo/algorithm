import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// P인 지점 찾고, 거기서 부터 PPAP인지 검사하고 PPAP 제거하고 P 넣고 -> 계속 반복 마지막에 남은게 PPAP면 PPAP.
		String input = br.readLine();
		StringBuilder sb = new StringBuilder(input);
		int idx = input.length();
		StringBuilder tmp = new StringBuilder();
		for (int i = 0; i < sb.length(); i++) {
			tmp.append(sb.charAt(i));
			while (tmp.length() >= 4) {
				if (tmp.substring(tmp.length() - 4).toString().equals("PPAP")) {
					tmp.delete(tmp.length() - 3, tmp.length());
				} else {
					break;
				}
			}
		}
		if (tmp.toString().equals("P")) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}
}