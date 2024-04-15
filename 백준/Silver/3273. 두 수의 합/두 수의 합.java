import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int target = Integer.parseInt(br.readLine());
        int res = 0;
        int[] numbers = new int[size];
        for(int i=0; i<size; i++){
            numbers[i] = Integer.parseInt(input[i]);
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < size; i++) {
            int a = numbers[i];
            int diff = target - a;
            if (map.containsKey(diff)) {
                res++;
            }
            map.put(a, i);
        }

        System.out.println(res);
    }
}