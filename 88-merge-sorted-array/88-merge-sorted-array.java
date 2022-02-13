class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] a=new int[m+n];
        int i=0,j=0;
        int k=0;
        while(i<m && j<n){
            if(nums1[i] < nums2[j]){
                a[k++]=nums1[i];
                i++;
            }
            else{
                a[k++]=nums2[j];
                j++;
            }
        }
        while(i<m)
            a[k++]=nums1[i++];
        while(j<n)
            a[k++]=nums2[j++];
        for(int p=0;p<(m+n);p++)
            nums1[p]=a[p];
    }
}