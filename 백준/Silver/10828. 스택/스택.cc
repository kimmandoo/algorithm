#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios::sync_with_stdio(0), cin.tie(0);
    int n;
    cin >> n;
    stack<int> s;
    for (int i = 0; i < n; i++) {
        string cmd;
        cin >> cmd;
        if (cmd == "push") {
            int v;
            cin >> v;
            s.push(v);
        }
        else if (cmd == "pop")
        {
            if (s.size() > 0) {
                cout << s.top();
                s.pop();
            }
            else {
                cout << -1;
            }
            cout << "\n";
        }
        else if (cmd == "size")
        {
            cout << s.size();
            cout << "\n";
        }
        else if (cmd == "top")
        {
            if (s.size() > 0) {
                cout << s.top();
            }
            else {
                cout << -1;
            }
            cout << "\n";
        }
        else { // empty
            if (s.empty()) {
                cout << 1;
            }
            else {
                cout << 0;
            }
            cout << "\n";
        }
    }

    return 0;
}