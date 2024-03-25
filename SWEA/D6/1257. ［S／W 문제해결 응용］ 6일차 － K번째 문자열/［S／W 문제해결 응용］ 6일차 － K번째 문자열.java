import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int k = Integer.parseInt(br.readLine());
			String in = br.readLine();
			TreeSet<String> ts = new TreeSet();
			for (int i = 0; i < in.length(); i++) {
				for (int j = i; j < in.length(); j++) {
					ts.add(in.substring(i, j+1));
				}
			}
			Object[] os = ts.toArray();
			String result = k - 1 < os.length ? (String) os[k - 1] : "none";

			System.out.println("#" + tc + " " + result);
		}
	}
}