class Solution {
    public double averageWaitingTime(int[][] customers) {
        double totalWaitingTime = 0d;
		int startTime = 0, arrivalTime = 0, preparationTime = 0;

		for (int[] customer : customers) {
			arrivalTime = customer[0];
			preparationTime = customer[1];
			startTime = Math.max(startTime, arrivalTime);
			totalWaitingTime += preparationTime + (startTime - arrivalTime);
			startTime += preparationTime;
		}

		return totalWaitingTime / customers.length;
    }
}