class Solution {
    public int minScore(int n, int[][] roads) {
        // Build adjacency list storing pairs of (neighbor, distance)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }
        int minScore = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int[] neighbor : adj.get(curr)) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                minScore = Math.min(minScore, weight);

                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                }
            }
        }
        return minScore;
    }
}