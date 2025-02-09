import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k, r, c;
    static int[] di = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dj = {0, 1, 1, 1, 0, -1, -1, -1};
    static List<int[]> queens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("res/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            queens.add(new int[]{x, y}); // 퀸의 위치를 다 기억한다
        }

        boolean king = attack(r, c);
        boolean escape = go();

        if (king && !escape) {
            System.out.println("CHECKMATE");
        } else if (!king && !escape) {
            System.out.println("STALEMATE");
        } else if (king) {
            System.out.println("CHECK");
        } else {
            System.out.println("NONE");
        }
    }

    static boolean go() {
        for (int i = 0; i < 8; i++) {
            int ni = r + di[i];
            int nj = c + dj[i];
            if (isValid(ni, nj) && !attack(ni, nj)) {
                return true;
            }
        }
        return false;
    }

    static boolean attack(int row, int col) {
        for (int[] queen : queens) {
            int qRow = queen[0], qCol = queen[1];
            if (qRow == row || qCol == col || Math.abs(qRow - row) == Math.abs(qCol - col)) {
                return true;
            }
        }
        return false;
    }

    static boolean isValid(int ci, int cj) {
        return ci >= 0 && ci < n && cj >= 0 && cj < n;
    }
}
