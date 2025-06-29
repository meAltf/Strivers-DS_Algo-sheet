class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        ArrayList<Integer> bfsList = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        vis[0] = true;

        while(!queue.isEmpty()){
            Integer node = queue.poll();
            bfsList.add(node);
                
            for(int neghbour : adj.get(node)){
                if(vis[neghbour] == false){
                    vis[neghbour] = true;
                    queue.add(neghbour);
                }
            }
        }
        return bfsList;
    }
}
