class Solution {

    public long maximumValueSum(int[][] board) {
        long res = Long.MIN_VALUE;
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        int index = 0;
        for (int[] arr : board) {
            PriorityQueue<List<Integer>> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.get(0), b.get(0)));
            for (int i = 0; i < arr.length; i++) {
                queue.add(new ArrayList<>(Arrays.asList(arr[i], i)));
                if (queue.size() > 3) queue.poll();
            }
            map.put(index, new ArrayList<>());
            while (!queue.isEmpty()) {
                map.get(index).add(queue.poll());
            }
            index++;
        }
        for (int i = 0; i < board.length - 2; i++) {
            for (int j = i + 1; j < board.length - 1; j++) {
                for (int k = j + 1; k < board.length; k++) {
                    List<List<Integer>> arr1 = map.get(i);
                    List<List<Integer>> arr2 = map.get(j);
                    for (int l = 0; l < arr1.size(); l++) {
                        for (int m = 0; m < arr2.size(); m++) {
                            if (arr1.get(l).get(1) != arr2.get(m).get(1)) {
                                List<List<Integer>> arr3 = map.get(k);
                                for (int n = 0; n < arr3.size(); n++) {
                                    if (arr3.get(n).get(1) != arr1.get(l).get(1) && arr3.get(n).get(1) != arr2.get(m).get(1)) {
                                        res = Math.max(res, (long) (arr1.get(l).get(0) + arr2.get(m).get(0)) + arr3.get(n).get(0));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }
}
