class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer,Set<Character>> rmap=new HashMap<>();
        HashMap<Integer,Set<Character>> cmap=new HashMap<>();
        HashMap<Integer,Set<Character>> dmap=new HashMap<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(!isValid(rmap,i,board[i][j]))
                    return false;
                if(!isValid(cmap,j,board[i][j]))
                    return false;
                if(!isValid(dmap,getGrid(i,j),board[i][j]))
                    return false;
            }
        }
        return true;
    }
    public static boolean isValid(HashMap<Integer,Set<Character>> map, int i, char ch){
        if(ch=='.')
            return true;
        if(map.containsKey(i)==true){
            Set<Character> set=map.get(i);
            if(set.contains(ch)==true)
                return false;
            set.add(ch);
            map.put(i,set);
        }
        else{
            Set<Character> set=new HashSet<>();
            set.add(ch);
            map.put(i,set);
        }
        return true;
    }
    public static int getGrid(int i,int j){
        if(i>=0 && i<=2)
            return j/3+1;
        else if(i>=3 && i<=5)
            return j/3+4;
        else
            return j/3+7;
    }
}