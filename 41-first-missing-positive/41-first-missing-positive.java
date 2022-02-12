class Solution {
    public int firstMissingPositive(int[] A) {
         int c=1;
        Arrays.sort(A);
        HashSet<Integer> hs=new HashSet<>();
        int n=A.length;
        for(int i=0;i<n;i++)
            hs.add(A[i]);
        Iterator<Integer> it=hs.iterator();
        int size=hs.size();
        int[] a=new int[size];
        int in=0;
        while(it.hasNext()){
            a[in++] = it.next();
        }
        Arrays.sort(a);
        for(int i=0;i<size;i++){
            if(a[i] <= 0)
            continue;
            if(a[i] == c)
            c++;
            else
            break;
        }
        return c;
    }
}