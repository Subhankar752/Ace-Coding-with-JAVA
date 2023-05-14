class Pair{
    int x;
    int y;
    int steps;
    Pair(int x,int y,int steps){
        this.x=x;
        this.y=y;
        this.steps=steps;
    }
}
class Solution {
    public int maxMoves(int[][] grid) {
        int max=0;
        for(int i=0;i<grid.length;i++){
            int cnt=bfs(grid,i);
            max=Math.max(max,cnt);
        }
        return max;
    }
    public int bfs(int[][] grid,int row){
        Queue<Pair> qu=new LinkedList<>();
        qu.add(new Pair(row,0,0));
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        vis[row][0]=true;
        int steps=0;
        while(!qu.isEmpty()){
            Pair p=qu.poll();
            int x=p.x;
            int y=p.y;
            steps=p.steps;
            int diri[]={-1,0,1};
            int dirj[]={1,1,1};
            for(int i=0;i<3;i++){
                int curri=x+diri[i];
                int currj=y+dirj[i];
                if(curri>=0 && curri<grid.length && currj>=0 && currj<grid[0].length && !vis[curri][currj] && grid[curri][currj]>grid[x][y]){
                    qu.add(new Pair(curri,currj,steps+1));
                    vis[curri][currj]=true;
                }
            }
        }
        return steps;
    }
}