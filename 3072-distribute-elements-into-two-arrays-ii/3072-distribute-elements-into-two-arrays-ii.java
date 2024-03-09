class Solution {

    private int counter(ArrayList<Node> list, int val, int size) {
        int res = size, l = 0, r = size - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            Node curr = list.get(mid);
            if (curr.val > val) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }

    class Node {
        int idx;
        int val;

        Node(int v, int i) {
            idx = i;
            val = v;
        }
    }

    public int[] resultArray(int[] nums) {
        ArrayList<Node> arr1 = new ArrayList<>();
        ArrayList<Node> arr2 = new ArrayList<>();

        arr1.add(new Node(nums[0], 0));
        arr2.add(new Node(nums[1], 0));
        
        int size1 = 1, size2 = 1;

        int n = nums.length;
        for (int i = 2; i < n; i++) {
            int idx1 = counter(arr1, nums[i], size1);
            int idx2 = counter(arr2, nums[i], size2);

            int val1 = size1 - idx1, val2 = size2 - idx2;

            if (val1 > val2) {
                arr1.add(idx1, new Node(nums[i], size1));
                size1++;
            } else if (val1 < val2) {
                arr2.add(idx2, new Node(nums[i], size2));
                size2++;
            } else {
                if (size1 <= size2) {
                    arr1.add(idx1, new Node(nums[i], size1));
                    size1++;
                } else {
                    arr2.add(idx2, new Node(nums[i], size2));
                    size2++;
                }
            }
        }

        int res[] = new int[n];
        int i = 0, k = 0;
        while (i < size1) {
            Node curr = arr1.get(i++);
            res[curr.idx] = curr.val;
        }
        
        i = 0;
        while (i < size2) {
            Node curr = arr2.get(i++);
            res[size1 + curr.idx] = curr.val;
        }

        return res;
    }
}
