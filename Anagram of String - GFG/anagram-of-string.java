// { Driver Code Starts
//saksham raj seth
import java.util.*;
class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s,String s1)
        {
        //add code here.
        int[] fr1 = new int[26];
        int[] fr2 = new int[26];
        for(char ch : s.toCharArray()){
            fr1[ch - 'a']++;
        }
        for(char ch : s1.toCharArray()){
            fr2[ch - 'a']++;
        }
        int ans = 0;
        for(int i = 0 ; i < 26 ; i++){
            if(fr1[i] != fr2[i]){
                ans += Math.abs(fr1[i] - fr2[i]);
            }
        }
        return ans;
        }
}