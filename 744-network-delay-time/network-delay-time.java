class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] network : times){
            int u = network[0];
            int v = network[1];
            int w = network[2];
            graph.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        dist[k] = 0;
        pq.add(new int[]{k,0});

        while(!pq.isEmpty()){
            int[] curr = pq.remove();
            int node = curr[0];
            int time = curr[1];
            for(int[] neighbour : graph.get(node)){
                int next = neighbour[0];
                int weight = neighbour[1];
                if(time + weight < dist[next]){

                    dist[next] = time + weight;

                    pq.offer(new int[]{next,dist[next]});
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            max = Math.max(max,dist[i]);
        }
        return max;
    }
}