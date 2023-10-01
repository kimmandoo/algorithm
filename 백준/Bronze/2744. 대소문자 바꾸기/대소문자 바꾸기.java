import java.io.*;

// 32를 빼면 대문자가 된다. 65 = A
public class Main{
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] input = br.readLine().toCharArray();

        for(int i=0; i< input.length; i++){
            if(input[i] >= 65+32) sb.append(Character.toChars(input[i]-32));
            else sb.append(Character.toChars(input[i]+32));
        }

        System.out.println(sb);
    }
}