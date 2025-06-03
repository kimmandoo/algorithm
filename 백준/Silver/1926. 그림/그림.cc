#include <iostream>
#include <utility>
#include <queue>
#include <algorithm> // min, max쓰려면 필요함

using namespace std;

int n, m;
int dx[4] = { -1, 0, 1, 0 };
int dy[4] = { 0, 1, 0, -1 };
bool v[502][502];
bool b[502][502];
int maxVal;
int cnt;

void draw(int x, int y) {
	int tmp = 1;
	queue<pair<int, int>> q;
	q.push({ x, y });
	v[x][y] = 1;
	while (!q.empty()) {
		auto cur = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int nx = dx[i] + cur.first;
			int ny = dy[i] + cur.second;

			if (nx > n || nx < 0 || ny > m || ny < 0) continue;
			if (v[nx][ny] || !b[nx][ny]) continue;
			v[nx][ny] = 1;
			q.push({ nx, ny });
			tmp++;
		}
	}

	cnt++;
	maxVal = max(maxVal, tmp);
}

int main() {
	ios::sync_with_stdio(0), cin.tie(0);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> b[i][j];
		}
	}

	// input 끝
	

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (b[i][j] && !v[i][j]) {
				draw(i, j);
			}
		}
	}

	cout << cnt << "\n" << maxVal;

	return 0;
}

