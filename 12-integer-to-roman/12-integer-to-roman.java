class Solution {
    public String intToRoman(int num) {
        int[] intCode={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] code={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int n=intCode.length;
        StringBuilder s=new StringBuilder();
        for(int i=0;i<n;i++){
            while(num>=intCode[i]){
                s.append(code[i]);
                num-=intCode[i];
            }
        }
        
        return s.toString();
    }
}