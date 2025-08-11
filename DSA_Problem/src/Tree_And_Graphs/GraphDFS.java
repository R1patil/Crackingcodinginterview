package Tree_And_Graphs;

import java.util.*;

public class GraphDFS {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", Arrays.asList("D"));
        graph.put("D", new ArrayList<>());

        Set<String> visited = new HashSet<>();
        dfs(graph, "D", visited);
    }

    public static void dfs(Map<String, List<String>> graph, String node, Set<String> visited) {
        if (visited.contains(node)) return;

        visited.add(node);
        System.out.println("Visited: " + node);

        for (String neighbor : graph.get(node)) {
            dfs(graph, neighbor, visited);
        }
    }
}
