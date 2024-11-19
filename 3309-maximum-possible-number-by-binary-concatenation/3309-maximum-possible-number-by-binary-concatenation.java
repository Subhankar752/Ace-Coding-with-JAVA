class Solution {
    public int maxGoodNumber(int[] nums) {
        Integer[] integerNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(integerNums, (a, b) -> {
            String binA = Integer.toBinaryString(a);
            String binB = Integer.toBinaryString(b);
            return (binB + binA).compareTo(binA + binB);
        });
        
        StringBuilder binaryConcatenation = new StringBuilder();

        for (int num : integerNums) {
            binaryConcatenation.append(Integer.toBinaryString(num));
        }
        
        return Integer.parseInt(binaryConcatenation.toString(), 2);
    }
}