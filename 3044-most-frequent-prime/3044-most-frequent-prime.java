class Solution {

    class Pair {
        int a;
        int b;

        Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public int mostFrequentPrime(int[][] mat) {
        Map<Integer, Integer> map = new HashMap<>();
        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int num = mat[i][j];

                //top
                int ii = i - 1;
                int jj = j;
                while (ii >= 0) {
                    num = num * 10 + mat[ii][j];
                    ii--;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //top-right
                ii = i - 1;
                jj = j + 1;
                num = mat[i][j];
                while (ii >= 0 && jj < cols) {
                    num = num * 10 + mat[ii][jj];
                    ii--;
                    jj++;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //right
                jj = j + 1;
                num = mat[i][j];
                while (jj < cols) {
                    num = num * 10 + mat[i][jj];
                    jj++;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //low-right
                num = mat[i][j];
                ii = i + 1;
                jj = j + 1;
                while (ii < rows && jj < cols) {
                    num = num * 10 + mat[ii][jj];
                    ii++;
                    jj++;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //low
                num = mat[i][j];
                ii = i + 1;
                while (ii < rows) {
                    num = num * 10 + mat[ii][j];
                    ii++;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //low-left
                num = mat[i][j];
                ii = i + 1;
                jj = j - 1;
                while (ii < rows && jj >= 0) {
                    num = num * 10 + mat[ii][jj];
                    ii++;
                    jj--;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //left
                num = mat[i][j];
                jj = j - 1;
                while (jj >= 0) {
                    num = num * 10 + mat[i][jj];
                    jj--;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }

                //top-left
                num = mat[i][j];
                ii = i - 1;
                jj = j - 1;
                while (ii >= 0 && jj >= 0) {
                    num = num * 10 + mat[ii][jj];
                    ii--;
                    jj--;

                    if (map.containsKey(num)) {
                        map.put(num, map.get(num) + 1);
                    } else {
                        map.put(num, 1);
                    }
                }
            }
        }

        List<Pair> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            int key = m.getKey();
            int val = m.getValue();
            if (prime(key) && key > 10) {
                list.add(new Pair(key, val));
            }
        }

        Collections.sort(
            list,
            (aa, bb) -> {
                if (bb.b == aa.b) {
                    return bb.a - aa.a;
                } else {
                    return bb.b - aa.b;
                }
            }
        );

        if (list.size() == 0) {
            return -1;
        }

        return list.get(0).a;
    }

    public boolean prime(int n) {
        if (n <= 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
