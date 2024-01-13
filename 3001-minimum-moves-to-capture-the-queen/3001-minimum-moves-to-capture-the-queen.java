class Solution {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        a--;
        b--;
        c--;
        d--;
        e--;
        f--;

        //rook horizontal right
        int j = b;
        while (j < 8) {
            if (a == e && j == f) {
                return 1;
            }

            if (a == c && j == d) {
                break;
            }

            j++;
        }

        //rook horizontal left
        j = b;
        while (j >= 0) {
            if (a == e && j == f) {
                return 1;
            }

            if (a == c && j == d) {
                break;
            }

            j--;
        }

        //rook veritcal down
        int i = a;
        while (i < 8) {
            if (i == e && b == f) {
                return 1;
            }

            if (i == c && b == d) {
                break;
            }

            i++;
        }

        //rook veritcal up
        i = a;
        while (i >= 0) {
            if (i == e && b == f) {
                return 1;
            }

            if (i == c && b == d) {
                break;
            }

            i--;
        }

        //bishop up left
        i = c;
        j = d;
        while (i >= 0 && j >= 0) {
            if (i == e && j == f) {
                return 1;
            }

            if (i == a && j == b) {
                break;
            }

            i--;
            j--;
        }

        //bishop up right
        i = c;
        j = d;
        while (i >= 0 && j < 8) {
            if (i == e && j == f) {
                return 1;
            }

            if (i == a && j == b) {
                break;
            }

            i--;
            j++;
        }

        //bishop down right
        i = c;
        j = d;
        while (i < 8 && j < 8) {
            if (i == e && j == f) {
                return 1;
            }

            if (i == a && j == b) {
                break;
            }

            i++;
            j++;
        }

        //bishop down left
        i = c;
        j = d;
        while (i < 8 && j >= 0) {
            if (i == e && j == f) {
                return 1;
            }

            if (i == a && j == b) {
                break;
            }

            i++;
            j--;
        }

        return 2;
    }
}
