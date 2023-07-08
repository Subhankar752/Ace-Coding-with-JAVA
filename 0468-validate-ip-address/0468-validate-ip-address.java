class Solution {

    public String validIPAddress(String queryIP) {
        if (isIPV4(queryIP) == true) return "IPv4"; else if (isIPV6(queryIP) == true) return "IPv6"; else return "Neither";
    }

    boolean isIPV4(String s) {
        if (s.contains(":") || s.startsWith(".") || s.endsWith(".")) {
            return false;
        }

        String[] arr = s.split("\\.");

        if (arr.length != 4) {
            return false;
        }

        for (String t : arr) {
            if (t.length() == 0 || t.length() > 3) return false;

            for (char c : t.toCharArray()) {
                if (Character.isLetter(c)) {
                    return false;
                }
            }

            int num = Integer.parseInt(t);
            if (num < 0 || num > 255) {
                return false;
            }

            if (t.length() > 1 && (t.startsWith("0") || t.startsWith("00") || t.equals("000"))) {
                return false;
            }
        }

        return true;
    }

    boolean isIPV6(String s) {
        if (s.contains(".") || s.startsWith(":") || s.endsWith(":")) {
            return false;
        }

        String[] arr = s.split(":");

        if (arr.length != 8) {
            return false;
        }

        for (String t : arr) {
            if (t.length() == 0 || t.length() > 4) return false;

            for (char c : t.toCharArray()) {
                if (Character.isLetter(c)) {
                    if (Character.isUpperCase(c) && c > 'F') {
                        return false;
                    }
                    if (Character.isLowerCase(c) && c > 'f') {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
