class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int n=energy.length;
        int ene=initialEnergy;
        int exp=initialExperience;
        int c=0,i=0;
        while(i<n){
            if(exp>experience[i] && ene>energy[i]){
                exp=exp+experience[i];
                ene=ene-energy[i];
                i++;
            }
            else{
                if(exp<=experience[i]){
                    c++;
                    exp++;
                }
                if(ene<=energy[i]){
                    c++;
                    ene++;
                }
            }
        }
        return c;
    }
}