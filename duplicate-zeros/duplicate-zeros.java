class Solution {
    public void duplicateZeros(int[] arr) {
        int[] arr2 = arr.clone();
		int i = 0, j = 0;
		
		while (j < arr.length) {
			if (arr2[i] == 0 && j < arr.length - 1) {
				arr[j++] = 0;
				arr[j++] = 0;
			} else {
				arr[j++] = arr2[i];
			}
			i++;
		}
    }
}