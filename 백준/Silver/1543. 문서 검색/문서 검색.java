import java.io.*;

class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String word = br.readLine();
        int startIndex = 0;
        int count = 0;
        while (true) {
            int idx = doc.indexOf(word, startIndex);
            if (idx < 0)
                break;
            startIndex = idx + word.length();
            count++;
        }
        System.out.println(count);
    }
}