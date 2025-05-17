#include <list>
#include <iostream>
#include <algorithm>

using namespace std;

void out(list<char> ll){
    for(auto c: ll){
        cout << c;
    }
    cout << "\n";
}

int main(){
    ios::sync_with_stdio(0), cin.tie(0);
    string input;
    cin >> input;
    list<char> ll;
    list<char>::iterator t = ll.begin();
    for(auto c: input){
        ll.insert(t, c);
    }
    
    int tc = 0; 
    cin >> tc;
    for(int i=0; i<tc; i++){
        char cmd; 
        char in;
        cin >> cmd;
        if(cmd == 'P'){
            cin >> in;
            ll.insert(t, in);
        }
        if(cmd == 'L'){
            if(t != ll.begin()) t--;
        }
        if(cmd == 'D'){
            if(t != ll.end()) t++;
        }
        if(cmd == 'B'){
            if(t != ll.begin()){ // 맨 앞이 아닐 때만
                t--; // 하나 뒤로 돌린다음 삭제해야됨
                t = ll.erase(t);
                // t가 가리키는 위치를 지우고 그 다음위치를 반환함
            }
        }
    }
    out(ll);
    return 0;
}