class Solution {
    public int minimumDeviation(int[] nums) {
        TreeSet<Integer>  temp = new TreeSet<>(); 
    for(int i:nums)
    {
        if(i%2==0)
        {
            temp.add(i);
        }
        else
        {
            temp.add(i*2);
        }
    }
    int min=temp.last()-temp.first();
    while(temp.last()%2==0)
    {
        int m = temp.last();
        temp.remove(m);
        temp.add(m/2);
        min = Math.min(min,temp.last()-temp.first());
    }
    return min;
    }
}