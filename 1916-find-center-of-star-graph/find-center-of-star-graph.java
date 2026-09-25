class Solution {
    public int findCenter(int[][] edges) {
        int n = edges.length;
        int[] degree = new int[n+2];

        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            degree[u]++;
            degree[v]++;
            
        }
        for(int i=1;i<=n+1;i++){
            if(degree[i]==n) return i;
        }
        return -1;
    }
}