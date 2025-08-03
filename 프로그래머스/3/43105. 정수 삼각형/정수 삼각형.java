import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                
                // 현재 행의 가장 왼쪽 값일 경우
                // 바로 위(j)에서
                if (j == 0) {
                    triangle[i][j] += triangle[i-1][j];
                } 
                // 현재 행의 가장 오른쪽 값일 경우
                // 바로 위 왼쪽 대각선(j-1)
                else if (j == i) {
                    triangle[i][j] += triangle[i-1][j-1];
                } 
                // 중간에 위치한 값일 경우
                // 위쪽의 두 값(j-1, j) 중 더 큰 값을 선택
                else {
                    triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
                }
            }
        }

        int answer = 0;
        int lastRowIndex = triangle.length - 1;
        for (int i = 0; i < triangle[lastRowIndex].length; i++) {
            if (triangle[lastRowIndex][i] > answer) {
                answer = triangle[lastRowIndex][i];
            }
        }

        return answer;
    }
}