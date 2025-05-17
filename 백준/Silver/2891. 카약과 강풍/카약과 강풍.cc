#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int n, s, r;

int main() {
	cin.tie(0), ios::sync_with_stdio(0);
	cin >> n >> s >> r;

	vector<int> b;
	vector<int> a;

	for (int i = 0; i < s; i++) {
		int t;
        cin >> t;
		b.push_back(t);
	}
	for (int i = 0; i < r; i++) {
		int t; 
		cin >> t;
		a.push_back(t);
	}

	sort(b.begin(), b.end());
	sort(a.begin(), a.end());

	vector<int> bb;
	vector<int> aa;

    for (int d : b) {
        // 자가수복
        auto it = find(a.begin(), a.end(), d);
        if (it != a.end()) {
            a.erase(it);
        }
        else {
            bb.push_back(d);
        }
    }

    aa = a;

    int res = 0;

    for (int d : bb) { // 진짜 부서진 배 순회
        auto it = find(aa.begin(), aa.end(), d - 1); // 앞뒤 체크
        if (it != aa.end()) {
            aa.erase(it);
            continue;
        }

        it = find(aa.begin(), aa.end(), d + 1);
        if (it != aa.end()) {
            aa.erase(it);
            continue;
        }

        res++;
    }

    cout << res;

	return 0;
}