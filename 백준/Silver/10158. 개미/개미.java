import java.io.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] map = br.readLine().split(" ");
        String[] start = br.readLine().split(" ");
        int W = Integer.parseInt(map[0]);
        int H = Integer.parseInt(map[1]);
        int P = Integer.parseInt(start[0]);
        int Q = Integer.parseInt(start[1]);
        int T = Integer.parseInt(br.readLine());

        int p = (P + T) % (2 * W);
        int q = (Q + T) % (2 * H);
        if (p > W) p = 2 * W - p;
        if (q > H) q = 2 * H - q;
        System.out.println(p + " " + q);
    }
}