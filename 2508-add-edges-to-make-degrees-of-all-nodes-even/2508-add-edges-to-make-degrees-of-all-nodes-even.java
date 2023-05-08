class Solution {
    public boolean isPossible(int n, List<List<Integer>> edges) {
       ArrayList<Integer>[] a = new ArrayList[n+1];
        
        for(int i=0;i<=n;i++)
        {
            a[i] = new ArrayList<Integer>();
        }
        
        for(List<Integer> list : edges)
        {
            a[list.get(0)].add(list.get(1));
            a[list.get(1)].add(list.get(0));
        }
    
        int j=0;
        ArrayList<Integer> Oddlist = new ArrayList<>();
        for(ArrayList<Integer> temp:a)
        {
            if(temp.size()%2==1)
            Oddlist.add(j);
            j++;
        }
        
        if(Oddlist.size()==0)
            return true;
        else if(Oddlist.size()==2)
        {
            int[] t = new int[n+1];
            
            int a1 = Oddlist.get(0);
            int b1 = Oddlist.get(1);
            
            for(int x:a[a1])
                t[x]++;
            for(int x:a[b1])
                t[x]++;
            
            for(int i=1;i<=n;i++)
            {
                if(t[i]==0)
                    return true;
            }
            return false;
        }
        else if(Oddlist.size()==4)
        {
            int[] t = new int[n+1];
            
            int a1 = Oddlist.get(0);
            int b1 = Oddlist.get(1);
            int c1 = Oddlist.get(2);
            int d1 = Oddlist.get(3);
            
            if(!a[a1].contains(b1) && !a[c1].contains(d1))
                return true;
            if(!a[a1].contains(c1) && !a[b1].contains(d1))
                return true;
            if(!a[a1].contains(d1) && !a[b1].contains(c1))
                return true;
        }
        return false;
    }
}