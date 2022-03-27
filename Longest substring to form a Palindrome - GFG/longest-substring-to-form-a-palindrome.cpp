// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
//User function Template for C++

class Solution {
  public:
    int longestSubstring(string s) {
        // code here
        int result = 0, mask=0;; 
        map<int, int> m;         //To keep track of last index of each XOR operation
        m[mask] = -1;
        for(int i=0;i<s.size(); i++){ //for every char in the string
            int t=s[i]-'a';
            /*Turn the temp-th bit on if character occurs odd number of times
            and turn off the temp-th bit off if the character occurs even number of times*/
            mask^=(1<<t);
            if (m[mask]) result = max(result,i - m[mask]);//pal is found from index[mask] to i
            else m[mask] = i;// If x is not found then add its position in the index dict.
            for(int j = 0; j < 26; j++){ // Check for the palindrome of odd length
                int mask2 = mask^(1<<j);//cancel the occur of a char if it occurs odd number times
                if (m[mask2]) result =max(result,i - m[mask2]);
            }
        }
        return result;
    }
};

// { Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin>>S;

        Solution ob;
        cout << ob.longestSubstring(S) << endl;
    }
    return 0;
}  // } Driver Code Ends