package Tree_And_Graphs;

import java.util.*;

public class GraphCreate {
    public static void main(String[] args) {
        // Create the graph
        Map<String, List<String>> graph = new HashMap<>();

        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("D"));
        graph.put("D", Arrays.asList("D")); // No outgoing edges
        graph.put("E" , new ArrayList<>());
        // Print the graph
        for (String node : graph.keySet()) {
            System.out.println(node + " -> " + graph.get(node));
        }
        bfs(graph, "A");
    }

    public static void bfs(Map<String, List<String>> graph, String start) {
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println("Visited: " + current);

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }
    }

}
