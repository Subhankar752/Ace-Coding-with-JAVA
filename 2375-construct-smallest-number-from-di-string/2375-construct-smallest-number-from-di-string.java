// class Solution {
//     ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//     ArrayList<ArrayList<Integer>> valid = new ArrayList<>();
    
//     public String smallestNumber(String pattern) {
//         int n = pattern.length();
//         solve(n , new ArrayList<Integer>());
//         for(ArrayList<Integer> i : list){
//         if(isValid(i , pattern)){
//             valid.add(new ArrayList<>(i));
//             }
//         }
//         Collections.sort(valid , new Comparator<ArrayList<Integer>>(){
//             @Override
//             public int compare(ArrayList<Integer> a , ArrayList<Integer> b){
//                 int n = a.size();
//                 for(int i = 0 ; i < n ; i++){
//                     int x = a.get(i);
//                     int y = b.get(i);
//                     if(x < y){
//                         return -1;
//                     }
//                     if(x > y){
//                         return 1;
//                     }
//                 }
//                 return 1;
//             }
//         });
       
//         String res = "";
//         for(int i : valid.get(0)){
//             res += Integer.toString(i);
//         }
//         return res;
//     }
//     public boolean isValid(ArrayList<Integer> list , String st){
//         for(int i = 0 ; i < st.length() ; i++){
//             char c = st.charAt(i);
//             if(c == 'I'){
//                 if(list.get(i) >= list.get(i + 1))
//                     return false;
//             }
//             else{
//                  if(list.get(i) <= list.get(i + 1))
//                     return false;
//             }
//         }
//         return true;
//     }
//     public void solve(int n , ArrayList<Integer> temp){
//         if(temp.size() == n + 1){
//             list.add(new ArrayList<>(temp));
//             return;
//         }
    
//         for(int i = 1 ; i <= 9 ; i++){
//             if(!temp.contains(i)){
//                 temp.add(i);
//                 solve(n , temp);
//                 temp.remove(new Integer(i));
//             }
//         }
//     }
// }
class Solution {
    public String smallestNumber(String pattern) {
        StringBuilder str = new StringBuilder();
        helper(0, 1, pattern.toCharArray(), str);
        return str.reverse().toString();
    }

    int helper(int index, int count, char[] arr, StringBuilder str) {
        if (index != arr.length) {
            if (arr[index] == 'I')
                helper(index + 1, index + 2, arr, str);
            else
                count = helper(index + 1, count, arr, str);
        }

        str.append(count);
        return count + 1;
    }
}