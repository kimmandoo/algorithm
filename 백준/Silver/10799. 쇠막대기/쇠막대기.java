import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();
        int res = 0;
        Stack<Character> mongdungee = new Stack<>();
        for(int i=0; i<input.length; i++){
            if(i<input.length-1&& input[i] == '(' && input[i+1]==')'){
                // 레이져 -> 레이져 이전에 있었던 거 더해주기
                res += mongdungee.size();
                i++; // 레이져 발사

            }else if(input[i] == '(') {
                mongdungee.push(input[i]);
            }else if(input[i] == ')'){
                mongdungee.pop();
                res++;
            }
        }
        System.out.println(res);
    }
}