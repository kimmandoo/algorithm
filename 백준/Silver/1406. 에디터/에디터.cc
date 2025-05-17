#include <list>
#include <iostream>
#include <algorithm>

using namespace std;

void out(auto& ll){
    for(auto c: ll){
        cout << c;
    }
}

int main(){
    ios::sync_with_stdio(0), cin.tie(0);
    string input;
    cin >> input;
    list<char> ll;
    for(auto c: input){
        ll.push_back(c);
    }
    auto t = ll.end();
    
    int tc = 0; 
    cin >> tc;
    for(int i=0; i<tc; i++){
        char cmd; 
        char in;
        cin >> cmd;
        if(cmd == 'B'){
            if(t != ll.begin()){ // 맨 앞이 아닐 때만
                t--; // 하나 뒤로 돌린다음 삭제해야됨
                t = ll.erase(t);
                // t가 가리키는 위치를 지우고 그 다음위치를 반환함
            }
        }
        else if(cmd == 'L'){
            if(t != ll.begin()) t--;
        }
        else if(cmd == 'D'){
            if(t != ll.end()) t++;
        }
        else{
            cin >> in;
            ll.insert(t, in);
            
        }
    }
    out(ll);
    return 0;
}