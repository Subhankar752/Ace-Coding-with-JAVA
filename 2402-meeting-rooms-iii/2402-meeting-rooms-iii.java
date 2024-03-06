class Solution {

    public int mostBooked(int n, int[][] meetings) {
        int[] bookings = new int[n];
        long[] endTime = new long[n];
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < meetings.length; i++) {
            int start = meetings[i][0], end = meetings[i][1];
            boolean hasFoundRoom = false;
            int nextAvailableRoom = -1;
            long waitingDuration = Long.MAX_VALUE;
            
            for (int j = 0; j < n; j++) {
                if (endTime[j] < waitingDuration) {
                    waitingDuration = endTime[j];
                    nextAvailableRoom = j;
                }
                if (endTime[j] <= start) {
                    hasFoundRoom = true;
                    bookings[j]++;
                    endTime[j] = end;
                    break;
                }
            }
            
            if (!hasFoundRoom) {
                bookings[nextAvailableRoom]++;
                endTime[nextAvailableRoom] += (end - start);
            }
        }

        int maxBookings = -1, mostBookedRoom = -1;
        
        for (int i = 0; i < n; i++) {
            if (bookings[i] > maxBookings) {
                maxBookings = bookings[i];
                mostBookedRoom = i;
            }
        }
        
        return mostBookedRoom;
    }
}
