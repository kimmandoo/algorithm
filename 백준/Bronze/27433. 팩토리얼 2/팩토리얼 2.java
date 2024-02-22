import java.util.*;
import java.io.*;

public class Main {
	
	public static long f(long i) {
		if(i <1) return 1;
		else if(i == 2) return 2;
		else {
			return i*f(i-1);
		}
	}

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.print(f(n));
	}
}
