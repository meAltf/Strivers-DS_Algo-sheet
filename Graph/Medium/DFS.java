class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
      int V = adj.size();
      boolean[] vis = new boolean[V];
      //vis[0] = true;
      ArrayList<Integer> dfsList = new ArrayList<>();
      dfsCall(0, vis, adj, dfsList);
      return dfsList;
    }
    
    private void dfsCall(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, List<Integer> dfsList){
        // marking current node as visited
        vis[node] = true;
        dfsList.add(node);

        // getting neighbour nodes
        for(int neghbour : adj.get(node)){
            if(vis[neghbour] == false){
                dfsCall(neghbour, vis, adj, dfsList);
            }
        }
    }
}
