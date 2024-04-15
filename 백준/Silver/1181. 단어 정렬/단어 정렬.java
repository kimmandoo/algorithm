import java.util.*;
import java.io.*;

public class Main {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> input = new ArrayList<>();
        for(int i=0; i<n; i++){
            String t = sc.next();
            if(!input.contains(t)){
                input.add(t);
            }
        }
        Collections.sort(input);
        Collections.sort(input, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(int i=0; i<input.size(); i++){
            System.out.println(input.get(i));
        }
    }
}
