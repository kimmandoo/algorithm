/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/
		int[][] board = new int[9][9];

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int ans = 1;
			for (int i = 0; i < 9; i++)
				for (int j = 0; j < 9; j++)
					board[i][j] = sc.nextInt();
			
			// row, col 검사

			for (int i = 0; i < 9; i++) {
				int rsum = 0;
				int csum = 0;
				for (int j = 0; j < 9; j++) {
					rsum += board[i][j];
					csum += board[j][i];
				}
				if (rsum != 45 || csum != 45) {
					ans = 0;
					break;
				}
			}
			// 유효하지 않은 경우 검사 stop

			if (ans == 0) {
				System.out.printf("#%d 0\n",test_case);
				continue;
			}

			// 정사각형 구역 검사

			for (int i = 0; i < 9; i+=3) {
				for (int j = 0; j < 9; j+=3) {
					int sum = 0;
					for (int x = 0; x < 3; x++)
						for (int y = 0; y < 3; y++)
							sum += board[i+x][j+y];
					if (sum != 45) {
						ans = 0;
						break;
					}
				}
				if (ans == 0) break;					
			}
			System.out.println("#" + test_case + " " + ans);
            
		}
	}
}