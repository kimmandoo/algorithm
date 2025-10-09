import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        // 1. 모두 소문자로 변경
        String str1Lower = str1.toLowerCase();
        String str2Lower = str2.toLowerCase();

        // 2. 각 문자열을 다중집합으로 만들기
        ArrayList<String> s1 = new ArrayList<>();
        for (int i = 0; i < str1Lower.length() - 1; i++) {
            char a = str1Lower.charAt(i);
            char b = str1Lower.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                s1.add(str1Lower.substring(i, i + 2));
            }
        }

        ArrayList<String> s2 = new ArrayList<>();
        for (int i = 0; i < str2Lower.length() - 1; i++) {
            char a = str2Lower.charAt(i);
            char b = str2Lower.charAt(i + 1);
            if (Character.isLetter(a) && Character.isLetter(b)) {
                s2.add(str2Lower.substring(i, i + 2));
            }
        }
        
        // 3. 교집합과 합집합 크기 계산
        // 교집합 계산을 위해 s2 리스트를 복사 (원본 훼손 방지)
        ArrayList<String> copyS2 = new ArrayList<>(s2);
        int intersectionSize = 0;
        
        for(String str : s1) {
            // s1의 원소가 copyS2에 존재하면, 해당 원소 하나를 지우고 교집합 크기를 1 증가
            if(copyS2.remove(str)) {
                intersectionSize++;
            }
        }
        
        // 합집합 크기는 공식 이용: |A U B| = |A| + |B| - |A ∩ B|
        int unionSize = s1.size() + s2.size() - intersectionSize;

        // 4. 자카드 유사도 계산 및 최종 값 반환
        // 두 집합이 모두 공집합인 경우
        if (unionSize == 0) {
            return 65536;
        }

        // 유사도 계산 (소수점 계산을 위해 double로 형변환)
        double jaccard = (double) intersectionSize / unionSize;

        return (int) (jaccard * 65536);
    }
}