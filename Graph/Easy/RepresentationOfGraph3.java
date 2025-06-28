package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Using adjacency list | for weighted graph
 */

class Pair {
    int node;
    int weight;

    Pair(int node1, int weight1) {
        this.node = node1;
        this.weight = weight1;
    }
}

public class RepresentationOfGraph3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no of nodes
        int m = sc.nextInt(); // no of edges

        ArrayList<ArrayList<Pair>> adjListWeight = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adjListWeight.add(new ArrayList<>());
        }

        // Read edges with weight
        System.out.println("Enter edges in this format: u v weight");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int weight = sc.nextInt();

            adjListWeight.get(u).add(new Pair(v, weight));
            adjListWeight.get(v).add(new Pair(u, weight));

        }
    }
}
