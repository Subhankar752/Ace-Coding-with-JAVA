class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         ArrayList<Integer> list = new ArrayList<>();
//         int i = 0;
//         int j = 0;
//         int n = nums1.length;
//         int m = nums2.length;
//         while(i < n && j < m){
//             if(nums1[i] < nums2[j]){
//                 if(!list.contains(nums1[i]))
//                 list.add(nums1[i]);
//                 i++;
//             }
//             else if(nums1[i] > nums2[j]){
//                 if(!list.contains(nums2[j]))
//                 list.add(nums2[j]);
//                 j++;
//             }
//             else{
//                 if(!list.contains(nums1[i]))
//                 list.add(nums1[i]);
//                 i++;
//                 j++;
//             }
//         }
//         while(i < n){
//             if(!list.contains(nums1[i]))
//             list.add(nums1[i]);
//             i++;
//         }
//         while(j < m){
//             if(!list.contains(nums2[j]))
//             list.add(nums2[j]);
//             j++;
//         }
//         for(int k : list)
//             System.out.print(k + " ");
        
//         int size = list.size();
//         if(size%2 != 0){
//             double val = list.get(size/2) * 1.0;
//             return val;
//         }
//         else{
//             int val1 = list.get(size/2);
//             int val2 = list.get((size - 1)/2);
//             double val = 1.0 * (val1 + val2)/2;
//             return val;
//         }
  if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1= nums2;
            nums2 = temp;
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int lo = 0;
        int hi = n1;
        double median = 0.0;
        
        while(lo<=hi){
            
            int cut1 = (lo+hi)/2;
            int cut2 = (n1+n2+1)/2-cut1; //cut2=total_length-cut1
            
            int l1=cut1==0?Integer.MIN_VALUE:nums1[cut1-1];
            int l2=cut2==0?Integer.MIN_VALUE:nums2[cut2-1];
            int r1=cut1==n1?Integer.MAX_VALUE:nums1[cut1];
            int r2=cut2==n2?Integer.MAX_VALUE:nums2[cut2];
            
            if(l1<=r2 && l2<=r1){
                if((n1+n2) % 2 == 0){
                    //even
                    median = (Math.max(l1,l2) + Math.min(r1,r2)) /2.0;
                    return median;
                }else{
                    //odd
                    median = Math.max(l1,l2);
                    return median;
                }
            }else if(l1>r2){
                hi = cut1-1;
            }else{//l2>r1
                lo = cut1+1;
            } 
        }
        return median;
    }
}