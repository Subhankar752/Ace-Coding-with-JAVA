class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        //reverse(digits);
        int sum=0;
        int carry=1;
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=n-1;i>=0;i--){
            int t=digits[i]+carry;
            sum=t%10;
            carry=t/10;
            a.add(sum);
        }
        if(carry!=0)
            a.add(carry);
        int size=a.size();
        int[] ans=new int[size];
        for(int i=0;i<size;i++)
            ans[i]=a.get(i);
        reverse(ans);
        return ans;
    }
    public static void reverse(int[] a){
        int i=0;
        int j=a.length-1;
        while(i<j){
            int t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
    }
}