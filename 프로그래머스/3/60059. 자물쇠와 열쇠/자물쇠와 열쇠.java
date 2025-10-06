class Solution {
    static int n,m;
    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = true;
        m = key.length;
        n = lock.length;
        // 1. 자물쇠 확장
        int extSize = n + 2 * (m - 1);
        int[][] extendedLock = new int[extSize][extSize];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                extendedLock[i + m - 1][j + m - 1] = lock[i][j];
            }
        }

        // 2. 열쇠를 4번 회전 (0, 90, 180, 270도)
        for (int rotation = 0; rotation < 4; rotation++) {
            key = rot(key); // 회전

            // 3. 확장된 자물쇠 위에서 열쇠를 이동
            for (int i = 0; i < n + m - 1; i++) {
                for (int j = 0; j < n + m - 1; j++) {
                    // 4. 열쇠가 맞는지 검사
                    if (check(extendedLock, key, i, j)) {
                        return true; // 딱 맞는 경우를 찾으면 즉시 true 반환
                    }
                }
            }
        }

        return false;
    }
    
    public boolean check(int[][] extend, int[][] key, int ci, int cj){
        // int[][] copy = extend.clone(); // 이건 1차원에서만...
        
//         // 키 조합하기
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 copy[ci+i][cj+j] += key[i][j];
//             }
//         }
//         // 검사
//         for(int i=0; i<n; i++){
//             for(int j=0; j<n; j++){
//                 if(copy[i+m-1][j+m-1] != 1) return false;
//             }
//         }
        
//         return true;
        int extSize = extend.length;
        // 1. 깊은 복사 (Deep Copy)
        int[][] copy = new int[extSize][extSize];
        for(int i=0; i<extSize; i++) {
            for(int j=0; j<extSize; j++) {
                copy[i][j] = extend[i][j];
            }
        }

        // 키 조합하기 - 반복 범위를 m으로 수정 - 키를 맵에 붙이는 거니까
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                copy[ci + i][cj + j] += key[i][j];
            }
        }

        // 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i + m - 1][j + m - 1] != 1) { // 돌기가 겹치거나(2), 홈이 안채워지면(0)
                    return false;
                }
            }
        }

        return true;
    }
    
    public int[][] rot(int[][] key){
        int[][] rotate = new int[m][m];
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                rotate[j][m-i-1] = key[i][j];
            }
        }
        return rotate;
    }
}