package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Using Adjacency List | prefer to use always
 */
public class RepresentationOfGraph2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of nodes
        int m = sc.nextInt(); // no of edges

        // Adjacency List
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

    }
}
