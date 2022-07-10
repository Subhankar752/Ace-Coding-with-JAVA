class Solution {
    public int minDeletions(String s) {
        int count = 0;
		
		Map<Character,Integer> map = new HashMap<>();
        for (int i = 0 ; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        
		// creating max heap of frequencies
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder()); ;

		//queue.addAll(map.keySet());
		
        for (Map.Entry<Character,Integer> entry : map.entrySet())
        {
            queue.add(entry.getValue()); 
        }

		 while (queue.size() > 0) {
			int most_frequent = queue.remove();
			if (queue.size() == 0 ) {
				return count;
			}

			if (most_frequent == queue.peek()) {
				if (most_frequent > 1) {
					queue.add(most_frequent - 1);
				}
				count++;
			}
		}
		return count;
    }
}