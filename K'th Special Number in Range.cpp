#include <iostream> 
#include <string> 
using namespace std;

bool isSpecialNumber(int num) {
    string binary = bitset<32>(num).to_string();
    size_t pos = binary.find("101");
    return (pos != string::npos);
}

int kthSpecialNumber(int l, int r, int k) { 
    int count = 0; for (int num = l; num <= r; num++) { 
        if (isSpecialNumber(num)) { 
            count++; 
            if (count == k) return num;
        } 
    }
    return -1; 
}
