#include <bits/stdc++.h>

using namespace std;

 

string getCanonicalForm(const string &s) {

    string evenChars, oddChars;

    for (int i = 0; i < s.length(); ++i) {

        if (i % 2 == 0) {

            evenChars += s[i];

        } else {

            oddChars += s[i];

        }

    }

    

    sort(evenChars.begin(), evenChars.end());

    sort(oddChars.begin(), oddChars.end());

    

    return evenChars + oddChars;

}

 

int distinctStrings(vector<string> &arr, int n) {

    set<string> distinctForms;

    

    for (const string &s : arr) {

        distinctForms.insert(getCanonicalForm(s));

    }

    

    return distinctForms.size();

}
