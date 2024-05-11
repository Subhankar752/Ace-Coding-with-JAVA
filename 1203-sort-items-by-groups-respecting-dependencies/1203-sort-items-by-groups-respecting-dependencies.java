class Solution {

    private List<Integer> topoSort(List<List<Integer>> adj) {
        int n = adj.size(), indeg[] = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nbr : adj.get(i)) indeg[nbr]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.add(i);
        }

        while (q.size() != 0) {
            int node = q.remove();
            ans.add(node);

            for (int nbr : adj.get(node)) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) q.add(nbr);
            }
        }
        return ans.size() == n ? ans : new ArrayList<>();
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int groupNo = m;
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) group[i] = groupNo++;
        }

        List<List<Integer>> nodeAdj = new ArrayList<>();
        List<List<Integer>> groupAdj = new ArrayList<>();
        for (int i = 0; i < n; i++) nodeAdj.add(new ArrayList<>());
        for (int i = 0; i < groupNo; i++) groupAdj.add(new ArrayList<>());

        for (int node = 0; node < n; node++) {
            for (int prev : beforeItems.get(node)) {
                nodeAdj.get(prev).add(node);
                if (group[prev] != group[node]) {
                    groupAdj.get(group[prev]).add(group[node]);
                }
            }
        }

        List<Integer> nodeOrder = topoSort(nodeAdj);
        List<Integer> groupOrder = topoSort(groupAdj);

        if (nodeOrder.size() == 0 || groupOrder.size() == 0) {
            return new int[0];
        }

        List<List<Integer>> orderedGroups = new ArrayList<>();
        for (int i = 0; i < groupNo; i++) orderedGroups.add(new ArrayList<>());
        for (int node : nodeOrder) {
            orderedGroups.get(group[node]).add(node);
        }

        List<Integer> ans = new ArrayList<>();
        for (int grpInd : groupOrder) {
            for (int x : orderedGroups.get(grpInd)) ans.add(x);
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
