#include <iostream>
#include <vector>
using namespace std;

vector<int> dp;
int n;

int go(int target) {
    if(dp[target] != -1) return dp[target];
    
    dp[target] = go(target-1) + 1;
    
    if(target % 2 == 0) {
        dp[target] = min(dp[target], go(target/2) + 1);
    }
    if(target % 3 == 0) {
        dp[target] = min(dp[target], go(target/3) + 1);
    }
    return dp[target];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    dp.resize(n+1, -1);
    dp[1] = 0;
    
    cout << go(n) << '\n';
    
    return 0;
}