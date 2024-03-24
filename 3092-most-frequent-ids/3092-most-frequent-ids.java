class Solution {
    HashMap<Integer, Long> idToFreq = new HashMap<>();
    TreeMap<Long, Set<Integer>> freqToIds = new TreeMap<>();

    public long[] mostFrequentIDs(int[] nums, int[] freq) {
        int size = nums.length;
        long[] result = new long[size];

        for (int i = 0; i < size; i++) {
            int id = nums[i];
            long addedFreq = freq[i];
            long oldFreq = idToFreq.getOrDefault(id, 0L);
            long newFreq = addedFreq + oldFreq;

            updateIdToFreq(id, newFreq);
            updateFreqToIds(id, oldFreq, newFreq);

            result[i] = freqToIds.lastKey();
        }

        return result;
    }

    private void updateIdToFreq(int id, long newFreq) {
        idToFreq.put(id, newFreq);
    }

    private void updateFreqToIds(int id, long oldFreq, long newFreq) {
        if (oldFreq != 0) {
            freqToIds.get(oldFreq).remove(id);
            if (freqToIds.get(oldFreq).size() == 0) 
                freqToIds.remove(oldFreq);
        }

        if (!freqToIds.containsKey(newFreq)) {
            freqToIds.put(newFreq, new HashSet<>());
        }

        freqToIds.get(newFreq).add(id);
    }
}
