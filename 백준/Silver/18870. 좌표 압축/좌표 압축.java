import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Integer[] input = new Integer[n];
		Set<Integer> set = new TreeSet<>();
		for(int i =0; i<n; i++) {
			input[i] = sc.nextInt();
			set.add(input[i]);
		}
		
		Map<Integer, Integer> st = new HashMap<>();
		int idx = 0;
		for(int x : set) {
			st.put(x, idx++);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			sb.append(st.get(input[i])).append(" ");
		}
		
		System.out.println(sb);
	}

}
