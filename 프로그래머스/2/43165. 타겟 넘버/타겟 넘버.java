class Solution {
    static int cnt = 0;
    
    public void dfs(int[] num, int idx, int sum, int t){
        if(idx == num.length){
            if(t == sum) cnt++;
            return;
        }
        dfs(num, idx+1, sum+num[idx], t); // +
        dfs(num, idx+1, sum-num[idx], t); // -
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        // dfs
        dfs(numbers, 0, 0, target);
        
        return cnt;
    }
}