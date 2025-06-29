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


2. GFG | Problem statment :

/** Note : Input given as-  List of Lists where each list is a row of 0/1 values  **/

class Solution {
    static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int V){
        vis[node] = true;
        for(int i=0; i<V; i++){
            if(adj.get(node).get(i) == 1 && vis[i] == false){
                dfs(i, vis, adj, V);
            }
        }
    }
    
    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i=0; i<V; i++){
            if(vis[i] == false){
                count++;
                dfs(i, vis, adj, V);
            }
        }
        return count;
    }
};
