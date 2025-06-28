package Graphs;

import java.util.Scanner;

/**
 * Adjacency matrix
 **/
public class RepresentationOfGraph1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of nodes
        int m = sc.nextInt(); // no of edges

        // Adjacency matrix
        int[][] adj = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            adj[u][v] = 1;
            adj[v][u] = 1;
        }
    }
}
