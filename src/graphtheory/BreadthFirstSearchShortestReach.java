package graphtheory;

import java.util.*;

public class BreadthFirstSearchShortestReach {

    static class Graph {

        int V;
        HashMap<Integer, LinkedList<Integer>> adjList;

        Graph(int V) {
            this.V = V;
            adjList = new HashMap<>();

            for (int i = 1; i <= V; i++) {
                adjList.put(i, new LinkedList<>());
            }
        }

        void addEdges(Integer u, Integer v) {
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] bfs(Integer s) {
            Queue<Integer> frontier = new LinkedList<>();
            ArrayList<Integer> visited = new ArrayList<>();

            ArrayList<Integer> distance = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                distance.add(0);
            }

            frontier.add(s);
            visited.add(s);
            int edgeLength = 6;

            while (!frontier.isEmpty()) {
                int size = frontier.size();

                for (int i = 0; i < size; i++) {
                    Integer u = frontier.poll();
                    LinkedList<Integer> adj = adjList.get(u);

                    for (Integer v : adj) {
                        if (!visited.contains(v)) {
                            frontier.add(v);
                            visited.add(v);
                            distance.set(v - 1, edgeLength);
                        }
                    }
                }

                edgeLength += 6;
            }

            int[] result = new int[distance.size() - 1];
            int iResult = 0;

            for (int i = 0; i < distance.size(); i++) {
                if (i != s-1) {
                    if (distance.get(i) == 0)
                        result[iResult] = -1;
                    else
                        result[iResult] = distance.get(i);

                    ++iResult;
                }
            }

            return result;
        }
    }

    static int[] bfs(int n, int m, int[][] edges, int s) {
        Graph graph = new Graph(n);

        for (int i = 0; i < m; i++) {
            graph.addEdges(edges[i][0], edges[i][1]);
        }

        return graph.bfs(s);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);

                if (i != result.length - 1) {
                    System.out.print(" ");
                }
            }

            System.out.print("\n");
        }

        scanner.close();
    }
}
