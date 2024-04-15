import java.io.FileInputStream;
import java.util.Scanner;

class Main{
    public static void swapItem(char[][] map, int ia, int ja, int ib, int jb){
        char tmp = map[ia][ja];
        map[ia][ja] = map[ib][jb];
        map[ib][jb] = tmp;
    }

    public static int findMaxRow(char[][] map, int n){
        int tmpMax = 0;

        for(int i=0; i<n; i++){
            int len = 1;
            for(int j=1; j<n; j++){
                if(map[i][j-1] == map[i][j]){
                    len++;
                }else{
                    tmpMax = Math.max(tmpMax, len);
                    len = 1;
                }
            }
            tmpMax = Math.max(tmpMax, len);
        }
        return tmpMax;
    }

    public static int findMaxCol(char[][] map, int n){
        int tmpMax = 0;

        for(int i=0; i<n; i++){
            int len = 1;
            for(int j=1; j<n; j++){
                if(map[j-1][i] == map[j][i]){
                    len++;
                }else{
                    tmpMax = Math.max(tmpMax, len);
                    len = 1;
                }
            }
            tmpMax = Math.max(tmpMax, len);
        }
        return tmpMax;
    }

    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        for(int i=0; i<n; i++){
            char[] input = sc.next().toCharArray();
            int idx = 0;
            for(char k: input){
                map[i][idx++] = k;
            }
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if (j+1 < n && map[i][j] != map[i][j+1]){ // 앞으로 교환
                    swapItem(map, i,j, i, j+1);
                    ans = Math.max(ans, Math.max(findMaxRow(map, n), findMaxCol(map,n)));
                    swapItem(map, i,j, i, j+1);
                }
                if (i+1 < n && map[i][j] != map[i+1][j]){ // 아래로 교환
                    swapItem(map, i,j, i+1, j);
                    ans = Math.max(ans, Math.max(findMaxRow(map, n), findMaxCol(map,n)));
                    swapItem(map, i,j, i+1, j);
                }
            }
        }

        System.out.println(ans);

        sc.close();
    }
}