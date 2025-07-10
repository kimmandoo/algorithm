import java.util.*;

class Solution {
    boolean[] p;
    boolean[] v;
    int cnt = 0;
    HashSet<Integer> check;

    public int solution(String numbers) {
        erato(9999999);
        
        int len = numbers.length();
        v = new boolean[len];
        check = new HashSet();
        // perm(0, len, numbers);
        perm("", numbers);
        
        return cnt;
    }
    
    public void perm(String currentNum, String numbers) {
        // numbers의 모든 숫자를 한 번씩 시도
        for (int i = 0; i < numbers.length(); i++) {
            // 아직 사용하지 않은 숫자(v[i]가 false)인 경우
            if (!v[i]) {
                v[i] = true; // 사용했다고 표시
                
                // 현재 조합된 숫자에 새로운 숫자를 붙임
                String newNumStr = currentNum + numbers.charAt(i);
                int num = Integer.parseInt(newNumStr);
                
                // 생성된 숫자가 소수이고, 이전에 확인한 숫자가 아니라면
                if (p[num] && !check.contains(num)) {
                    cnt++;
                    check.add(num);
                }
                
                // 다음 숫자를 붙이기 위해 재귀 호출
                perm(newNumStr, numbers);
                
                // 재귀가 끝나면, 다른 조합을 위해 현재 숫자를 '사용 안 함' 상태로 되돌림 (백트래킹)
                v[i] = false;
            }
        }
    }
    
    public void erato(int n) {
        p = new boolean[n + 1];
        Arrays.fill(p, true);
        p[0] = false; // 0도 일단 소수가 아니다
        p[1] = false; // 1도 소수가 아니다

        for (int i = 2; i * i <= n; i++) {
            if (p[i]) {
                for (int j = i * i; j <= n; j += i) {
                    p[j] = false;
                }
            }
        }
    }
}