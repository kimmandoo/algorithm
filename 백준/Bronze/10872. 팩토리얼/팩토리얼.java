import java.util.*;
import java.io.*;

class Main{
	public static int facto(int n) {
		if(n<2) return 1;
		else {
			return n* facto(n-1);
		}
	}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(facto(n));
    }
}