class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree  = new int[numCourses];

        for(int[] pre : prerequisites){
            int c = pre[0];
            int p = pre[1];
            graph.get(p).add(c);
            indegree[c]++;
        }
        Queue<Integer> queue = new LinkedList<>();

        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        int[] ans = new int[numCourses];
        int index=0;
        
        while(!queue.isEmpty()){
            int node = queue.remove();
            ans[index++]=node;

            for(int neighbour : graph.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour]==0){
                    queue.add(neighbour);
                }
            }
        }
        if(index != numCourses){
            return new int[0];
        }
        return ans;
    }
}