#include <iostream>
#include <algorithm>
#include <vector>
#include <list>

using namespace std;

int main() {
	cin.tie(0), ios::sync_with_stdio(0);
	int n;
	cin >> n;
	vector<int> v(n);
	vector<int> s(n);
	for (int i = 0; i < n; i++) {
		cin >> s[i];
	}

	int sum = 0;
	for (int i = 0; i < n; i++) {
		sum += (i % 2 == 0 ? s[i] : -s[i]); // 짝수면 더하고, 홀수면 뺀다.
	}

	v[0] = sum / 2;

	for (int i = 1; i < n; i++) {
		v[i] = s[i - 1] - v[i - 1];
	}

	for (auto c: v) {
		cout << c << '\n';
	}

	return 0;
}