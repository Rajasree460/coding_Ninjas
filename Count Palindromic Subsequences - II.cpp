#include <unordered_map>

int countPalinSubseq(string &s) {
   
   // Find length of the string.
   int n = s.length();
   
   // To store the last index of each character.
   unordered_map<char, int> prevmap;
   unordered_map<char, int> nextmap;
   
   // To store the next and previous index of each character.
   vector<int> prev(n);
   vector<int> next(n);
   
   // Fill the 'prev' array.
   for(int i = 0; i < n; i++) {
       
       // Check if already present.
       if (prevmap.find(s[i]) != prevmap.end()) {
           
           // Assign previous index.
           prev[i] = prevmap[s[i]];
       } 
       else {
           // No same character present before this.
           prev[i] = -1;
       }
       
       // Store the index.
       prevmap[s[i]] = i;
   }
   
   // Fill the 'next' array.
   for(int i = n - 1; i >= 0; i--) {

       if (nextmap.find(s[i]) != nextmap.end()) {
           next[i] = nextmap[s[i]];
       } 
       else {
           next[i] = -1;
       }

       nextmap[s[i]] = i;

   }
   
   // To store recursive calls.
   vector<vector<int>> dp(n, vector<int>(n, 0));
   
   for(int i = 0; i < n; i++) {
       dp[i][i] = 1;
   }
   
   // Fill the table.
   for(int l = 2; l <= n; l++) {
       for(int i = 0; i < n - l + 1; i++) {
           int j = i + l - 1;
           
           // If the endpoints of subsequence are same.
           if(s[i] == s[j]) {
               
               // Update current indices.
               dp[i][j] = 2 * dp[i + 1][j - 1];
               
               // Store next index of 'ith' character.
               int left = next[i];
               
               // Store previous index of 'jth' character.
               int right = prev[j];
               
               // Check conditions.
               if(left < right) {
                   dp[i][j] -= dp[left + 1][right - 1];
               }
               else if(left == right) {
                   dp[i][j] += 1; 
               }
               else {
                   dp[i][j] += 2; 
               }
           } 
           
           // If endpoints are not equal.
           else {
               dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
           }
           
           // Take modulo.
           if(dp[i][j] < 0) {
               dp[i][j] = dp[i][j] + 1000000007;
           }
           else {
               dp[i][j] = dp[i][j] % 1000000007;
           }
       }
   }
   
   return dp[0][n - 1];
}
