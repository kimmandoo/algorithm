import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] res = new int[31]; // 1~30
		for(int i=1; i<29; i++) { // 제출인원은 28명
			int success = sc.nextInt();
			res[success] = 1;
		}
		for(int i=1; i<res.length; i++) {
			if(res[i]!=1)
				System.out.println(i);
		}
	}

}