#include <iostream>
#include <queue>
#include <set>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0);
    cin.tie(0); cout.tie(0);

    int N; cin >> N;
    set<string> s;
    int ans = 0;
    for(int i=0; i<N; ++i) {
        string chat; cin >> chat;

        if(chat == "ENTER") {
            s.clear();
            continue;
        }


        if(s.find(chat) == s.end()) {
            ++ans;
            s.insert(chat);
        }
        
    }

    cout << ans << '\n';

}