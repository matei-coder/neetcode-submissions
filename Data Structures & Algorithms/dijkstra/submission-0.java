class Solution {
    public Map<Integer, Integer> shortestPath(
            int n, List<List<Integer>> edges, int src) {

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            graph.get(u).add(new int[]{v, weight});
        }

        PriorityQueue<int[]> available = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        available.offer(new int[]{0, src});

        while (!available.isEmpty()) {
            int[] curr = available.poll();
            int dis = curr[0];
            int node = curr[1];

            if (dis != dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {
                int v = edge[0];
                int weight = edge[1];

                if (dis + weight < dist[v]) {
                    dist[v] = dis + weight;
                    available.offer(new int[]{dist[v], v});
                }
            }
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                map.put(i, -1);
            } else {
                map.put(i, dist[i]);
            }
        }

        return map;
    }
}
