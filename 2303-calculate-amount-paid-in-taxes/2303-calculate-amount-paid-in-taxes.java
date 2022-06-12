class Solution {
    public double calculateTax(int[][] brackets, int income) {
        double ans = 0.0;
        int n = brackets.length;
        int i = 0;
        int prev = 0;
        
        while(i < n && income > 0){
            int net = brackets[i][0] - prev;
            int rem = Math.min(income , net);
            income -= rem;
            double tax = (brackets[i][1]/(100 * 1.0)) * rem;
            ans += tax;
            prev = brackets[i][0];
            System.out.println(tax);
            i++;
        }
        return ans;
    }
}