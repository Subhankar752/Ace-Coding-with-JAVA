class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        char[] chars = s.toCharArray();

        int i = 0;

        // skip empty space
        while (i < chars.length && chars[i] == ' ') {
            i++;
        }

		// check against out-of-bounds because we'll do chars[i] below
        if (i == chars.length) {
            return 0;
        }

        boolean isPositive = true;

        // determine sign
        if (chars[i] == '-') {
            isPositive = false;
            i++;
        } else if (chars[i] == '+') {
            i++;
        }

        int result = 0;

        while (i < chars.length) {
            int next = chars[i] - '0';

            if (next < 0 || next > 9) {
                break;
            }

			// Here we rely on the fact that the negative range is only 1 more than the positive range in absolute size
			// If the difference was larger, we'd have to do separate checks based on whether the sign is (-) or (+)
			// in order to catch all the cases while always staying within the bounds.
            if (Integer.MAX_VALUE / 10 < result || Integer.MAX_VALUE - (result * 10) < next) {
                return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + next;

            i++;
        }

        return isPositive ? result : -result;
    

    }
}