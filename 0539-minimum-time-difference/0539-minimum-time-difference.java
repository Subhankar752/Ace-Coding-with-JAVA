class Solution {

    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        boolean[] arr = new boolean[24 * 60];
        for (int i = 0; i < n; i++) {
            int t = parse(timePoints.get(i));
            if (arr[t]) {
                return 0;
            } else {
                arr[t] = true;
            }
        }
        int min = Integer.MAX_VALUE;
        int pre = 0;
        int first = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]) {
                if (first == -1) {
                    first = i;
                } else {
                    min = Math.min(min, i - pre);
                }
                pre = i;
            }
        }
        min = Math.min(min, first - pre + 24 * 60);
        return min;
    }

    int parse(String s) {
        String[] arr = s.split(":");
        int hour = Integer.parseInt(arr[0]);
        int minute = Integer.parseInt(arr[1]);
        return hour * 60 + minute;
    }
}
