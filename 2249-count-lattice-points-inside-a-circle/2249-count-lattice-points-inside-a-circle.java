class Solution {
    public int countLatticePoints(int[][] circles) {
        HashSet<String> res = new HashSet<String>();
    for(int[] arr : circles){
        int x = arr[0], y = arr[1], r = arr[2];
        for(int i=x-r; i<=x+r; i++)
            for(int j=y-r; j<=y+r; j++)
                if((x-i)*(x-i) + (y-j)*(y-j) <= r*r)
                    res.add(i+","+j);
    }
    return res.size();
    }
}