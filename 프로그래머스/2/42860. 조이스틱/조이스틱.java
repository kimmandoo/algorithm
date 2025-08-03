class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        for (char c : name.toCharArray()) {
            answer += Math.min(c - 'A', 'Z' - c + 1);
        }

        int minMove = length - 1; 

        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            int turnMove = (i * 2) + (length - next);
            minMove = Math.min(minMove, turnMove);

            int reverseTurnMove = (length - next) * 2 + i;
            minMove = Math.min(minMove, reverseTurnMove);
        }

        answer += minMove;
        return answer;
    }
}