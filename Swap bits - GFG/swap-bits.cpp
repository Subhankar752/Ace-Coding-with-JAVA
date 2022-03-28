// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


 // } Driver Code Ends
class Solution{
public:    
    int swapBits(int x, int p1, int p2, int n)
    {
        // Code Here
        vector<int>v(32,0);
        int i=0,p=0;
        while(x){
            int t=x&1;
            v[i++]=t;
            x>>=1;
        }
        
        while(n--)
            swap(v[p1++],v[p2++]);
        
       for(int i=0;i<32;i++){
           if(v[i])
               x+=pow(2,p);
           p++;
       }
        return x;
    }
};

// { Driver Code Starts.

 
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int x,p1,p2,n;
		cin>>x>>p1>>p2>>n;
		Solution obj;
		int res=obj.swapBits(x,p1,p2,n);
		printf("%d\n", res);
	}
    return 0;
}  // } Driver Code Ends