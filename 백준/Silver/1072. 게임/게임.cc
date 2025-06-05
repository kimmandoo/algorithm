#include <iostream>
#include <utility>
#include <queue>
#include <algorithm>

using namespace std;

#define ll long long

int main() {
	ios::sync_with_stdio(0), cin.tie(0);

    ll x, y;
    cin >> x >> y;

    int z = (y * 100) / x;
    if (z >= 99) { // 소수점이 변화하지않음
        cout << -1;
        return 0;
    }

    ll l = 1, r = 1000000000;
    ll ans = -1;

    while (l <= r) {
        ll m = (l + r) / 2;
        int zz = ((y + m) * 100) / (x + m);
        if (zz > z) {
            ans = m;
            r = m - 1;
        }
        else {
            l = m + 1;
        }
    }

    cout << ans;

	return 0;
}