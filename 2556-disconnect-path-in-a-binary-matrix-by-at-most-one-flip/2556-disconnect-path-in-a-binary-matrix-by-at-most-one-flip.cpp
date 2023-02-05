bool dfs(vector<vector<int>>& a , int i , int j , int rows , int cols){
    if (i == rows - 1 and j == cols - 1) {
        return true;
    }

    a[i][j] = 0;
    int dir[][2] = {{0 , 1} , {1 , 0}};
    
    for (int k = 0 ; k < 2 ; k++) {
        int Y = j + dir[k][1];
        int X = i + dir[k][0];

        if(X >= 0 && Y >= 0 && X < rows && Y < cols && a[X][Y] == 1) {
            if(dfs(a , X , Y , rows , cols)) {
                return true;
            }
        }
    }

    return false;
}


int find(vector<vector<int> >& a)
{
    int cols = a[0].size();
    int rows = a.size();
   
    if(!dfs(a , 0 , 0 , rows , cols)) {
        return 0;
    }

   a[0][0] = 1;
    if(!dfs(a , 0 , 0 , rows , cols)) {
        return 1;
    }
    else{
        return 2;
    }
}

class Solution {
public:
    bool isPossibleToCutPath(vector<vector<int>>& nums) {
        int n = nums.size();
        int m = nums[0].size();

        if(find(nums) <= 1) 
            return true;
        
        return false;
    }
};