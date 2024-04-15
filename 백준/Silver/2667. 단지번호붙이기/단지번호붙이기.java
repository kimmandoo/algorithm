import java.io.*;
import java.util.*;

public class Main{
    static int N, count;
    static int[][] map;
  	// dx는 아래위로, dy는 좌우로 움직인다. 기존에 생각하던 그 좌표로 생각하면 무조건 헷갈림
    static int[] dx = {-1, 0, 1, 0}; // 12시 부터 시계방향
    static int[] dy = {0, 1, 0, -1};
    
    public static void dfs(int x, int y){
        map[x][y] = 0; // 방문 처리 대신에 0을 넣어줌. visited 배열로 방문 처리를 해도 됨
        count += 1; // 한 덩어리의 크기를 계산함. static이라 재귀돌 때도 쌓임.
        
        for(int i=0; i<4; i++){
            int nx = x + dx[i]; // 4방향 돌면서 확인함
            int ny = y + dy[i];
            
            if(nx>=0 && nx<N && ny>=0 && ny<N && map[nx][ny]==1) dfs(nx, ny);
          // 경계선도 고려해서 짜야됨. 좌표의 범위는 [0,N)
          // 재귀로 DFS 사용
        }
    }
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        
        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<N; j++){
                map[i][j] = str.charAt(j) - '0'; // 이러면 숫자만 남음 '1' - '0 ' = 1
            }
        }
        
        ArrayList<Integer> arr = new ArrayList<>();
      // 여기서 사용되는 arr는 그냥 단순 출력용. 이번 문제는 dfs만 할 줄 알면 풀리는 문제.
        int result = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                count = 0;
                if(map[i][j] == 1){
                    dfs(i,j);
                    arr.add(count);
                    result++;
                }
            }
        }
        
        Collections.sort(arr);
        System.out.println(result);
        for(int i : arr){
            System.out.println(i);
        }
    }
}