import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        StringBuffer sb = new StringBuffer(input);
        String reverse = sb.reverse().toString();

        int same = 1;
        if(!input.equals(reverse)){
            same = 0;
        }
        System.out.println(same);
    }
}

