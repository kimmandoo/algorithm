import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] countA = alphabetCount(br.readLine());
        int[] countB = alphabetCount(br.readLine());

        int ans = 0;
        for (int i = 0; i < 26; i++)
            ans += Math.abs(countA[i] - countB[i]);
        System.out.println(ans);
    }

    public static int[] alphabetCount(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i) - 'a']++;
        return count;
    }
}