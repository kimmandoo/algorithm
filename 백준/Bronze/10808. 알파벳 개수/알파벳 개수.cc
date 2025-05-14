#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    cin.tie(0); ios::sync_with_stdio(0);
    string input;
    cin >> input;
    int abc[26];
    fill(abc, abc+26, 0);
    
    for(int i=0; i<input.length(); i++){
        abc[input.at(i)-97]++;
    }
    for(int i: abc){
        cout << i << " ";
    }

    return 0;
}