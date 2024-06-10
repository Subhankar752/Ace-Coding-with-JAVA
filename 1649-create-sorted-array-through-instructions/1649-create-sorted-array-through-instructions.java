class Fenwick {
    public int[] tree; //Binary indexed Tree array

    //initialize a new Fenwick tree of size length
    public Fenwick(int length) {
        tree = new int[length];
    }

    //Returns the sum of values in an array from range [0, i]
    public int sum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i = i - (i & -i); //flip the last set bit using 2's compliment
        }
        return sum;
    }

    //Returns sum of values in the given range [start, end]
    public int sumRange(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    //updates the value at index i by "k" in tree
    public void update(int i, int k) {
        while (i < tree.length) {
            tree[i] += k;
            i = i + (i & -i); //add last set bit
        }
    }
}

class Solution {
    int mod = (int) (1e9 + 7);

    public int createSortedArray(int[] a) {
        if (a.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i : a) {
            max = Math.max(max, i);
        }

        Fenwick tree = new Fenwick(max + 1);
        int ans = 0;

        for (int i : a) {
            int less = tree.sum(i - 1);
            int more = tree.sumRange(i + 1, max);
            ans = (ans % mod + Math.min(less, more) % mod) % mod;
            tree.update(i, 1);
        }

        return ans;
    }
}
