class FreqStack {
	private final Map<Integer, Deque<Integer>> frequencyToStack = new HashMap<>();
	private final Map<Integer, Integer> numToMaxFrequency = new HashMap<>();
	private int maxFrequency;

	/**
	 * Constructs an empty frequency stack
	 */
	public FreqStack() {}

	/**
	 * Pushes an integer val onto the top of the stack.
	 *
	 * @param val integer to be pushed
	 */
	public void push(int val) {
		var frequency = numToMaxFrequency.compute(val, (k, v) -> v == null ? 1 : ++v);
		frequencyToStack.computeIfAbsent(frequency, k -> new ArrayDeque<>())
						.push(val);
		maxFrequency = Math.max(maxFrequency, frequency);
	}

	/**
	 * Removes and returns the most frequent element in the stack. 
	 * If there is a tie for the most frequent element, 
	 * the element closest to the stack's top is removed and returned.
	 *
	 * @return The most frequent element in the stack
	 */
	public int pop() {
		var stack = frequencyToStack.get(maxFrequency);
		var top = stack.pop();
		numToMaxFrequency.compute(top, (k, v) -> --v);
		if (stack.isEmpty())
			maxFrequency--;
		return top;
	}
}