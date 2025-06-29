1. Leetcode | Problem statment :

/** Note : Input given as-  List of Lists where each list contains neighbor nodes  **/
class Solution {
    private void dfs(int node, boolean[] vis, List<List<Integer>> adjList){
        vis[node] = true;
        for(int neighbour : adjList.get(node)){
            if(vis[neighbour] == false){
                dfs(neighbour, vis, adjList);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        // Need to convert matrix to list<list<int>>
        int V = isConnected.length;
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<V; i++){
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0; i<V; i++){
            for(int j=0; j<V; j++){
                if(i!=j && isConnected[i][j] == 1){
                    adjList.get(i).add(j);
                }
            }
        }

        // Now, find provinces
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                count++;
                dfs(i, vis, adjList);
            }
        }
        return count;
    }
}
