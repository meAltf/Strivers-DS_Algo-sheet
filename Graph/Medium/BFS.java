public List<Integer> bfsOfGraph(int V, List<List<Integer>> adj) {
        ArrayList<Integer> bfsList = new ArrayList<>();
        Boolean[] vis = new Boolean[V];
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
