import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        StringBuffer sb = new StringBuffer(a);
        String rA = sb.reverse().toString();
        sb = new StringBuffer(b);
        String rB = sb.reverse().toString();
        if(Integer.parseInt(rA) > Integer.parseInt(rB)) {
        	System.out.println(rA);
        }else {
        	System.out.println(rB);
        }
    }
}
