#include <bits/stdc++.h> 
long long binpow(long long a, long long b, long long m) {
    a %= m;
    long long res = 1;
    while (b > 0) {
        if (b & 1)
            res = res * a % m;
        a = a * a % m;
        b >>= 1;
    }
    return res;
}
string completeString(int n, vector<string> &a){
    // Write your code here.
    sort(a.begin(), a.end(), [] (string &fir, string &sec) {
        if (fir.size() == sec.size()) {
            return fir < sec;
        }
        return fir.size() < sec.size();
        });
    long long mod = 1e9 + 7;
    long long poww = 31;
    int ans = -1;
    int curSize = 0;
    map <long long, int> pos;
    for (int i = 0; i < n; i++) {
        long long powNow = 1;
        long long hashHere = 0;
        for (char c : a[i]) {
            hashHere = (hashHere + (c - 'a' + 1) * powNow) % mod;
            powNow = (powNow * poww) % mod;
        }
        if (a[i].size() == 1) {
            pos[hashHere] = 1;
            if (a[i].size() > curSize) {
                ans = i;
                curSize = a[i].size();
            }
        }
        else {
            long long toSub = ((a[i][a[i].size() - 1] - 'a' + 1) * binpow(poww, a[i].size() - 1, mod)) % mod;
            long long hashLeft = (hashHere -  toSub + mod) % mod;
            if (pos.count(hashLeft)) {
                pos[hashHere] = a.size();
                if (a[i].size() > curSize) {
                    ans = i;
                    curSize = a[i].size();
                }
            }
        }
    }
    if (ans == -1) return "None";
    return a[ans];
}
