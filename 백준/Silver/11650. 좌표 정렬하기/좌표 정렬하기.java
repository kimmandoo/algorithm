import java.util.*;
 
public class Main {
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		int[][] input = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			input[i][0] = in.nextInt();
			input[i][1] = in.nextInt();
		}
		
		Arrays.sort(input, (e1, e2) -> {
			if(e1[0] == e2[0]) {
				return e1[1] - e2[1];
			} else {
				return e1[0] - e2[0];
			}
		});
        StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
            sb.append(input[i][0]).append(" ").append(input[i][1]).append("\n");
		}
        System.out.println(sb);
	}
}