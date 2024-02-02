class Solution {

    public List<Integer> sequentialDigits(int low, int high) {
        Set<Integer> list = new HashSet<>();
        for (int i = String.valueOf(low).length(); i <= String.valueOf(high).length(); i++) {
            list.addAll(slideAndGet(i, low, high));
        }

        List<Integer> retList = new ArrayList(list);
        Collections.sort(retList);

        return retList;
    }

    public List<Integer> slideAndGet(int n, int min, int max) {
        String window = "123456789";
        List<Integer> list = new ArrayList<>();

        int i = 0, j = n;
        while (j <= 9) {
            int currSeq = Integer.parseInt(window.substring(i, i + n));
            if (currSeq <= max && currSeq >= min) {
                list.add(currSeq);
            }
            i++;
            j++;
        }

        return list;
    }
}
