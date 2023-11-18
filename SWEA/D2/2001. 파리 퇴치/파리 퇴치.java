import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int n = sc.nextInt();
            int [][] map = new int[n][n];
            int m = sc.nextInt(); // 파리채
            int max = 0;
            // map 생성
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    map[i][j] = sc.nextInt();
                }
            }
            // 파리채 시작
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    //smash[i][j]가 시작점. j+m < n, i+m < n
                    if(j+m <= n && i+m <= n){
                        int tmp = 0;
                        for(int a=0; a<m; a++){
                            for(int b=0;b<m; b++){
                                tmp+= map[a+i][b+j];
                            }
                        }
                        if(max < tmp) max = tmp;
                    }
                }
            }


            System.out.printf("#%d %d\n", test_case, max);

        }
    }
}
