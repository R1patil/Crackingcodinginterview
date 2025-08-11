import java.util.*;

public class BuildOrderDFS {

    public static List<String> findBuildOrder(String[] projects, String[][] dependencies) {
        // Step 1: Build the graph as an adjacency list
        Map<String, List<String>> graph = new HashMap<>();
        for (String project : projects) {
            graph.put(project, new ArrayList<>());
        }
        for (String[] pair : dependencies) {
            String from = pair[0];
            String to = pair[1];
            graph.get(from).add(to);  // from → to means "from must be built before to"
        }

        Set<String> visited = new HashSet<>();   // Fully processed nodes
        Set<String> visiting = new HashSet<>();  // Current DFS path (for cycle detection)
        Stack<String> result = new Stack<>();    // Store build order

        for (String project : projects) {
            if (!visited.contains(project)) {
                boolean hasNoCycle = dfs(project, graph, visited, visiting, result);
                if (!hasNoCycle) {
                    System.out.println("Cycle detected! No valid build order.");
                    return new ArrayList<>();  // return empty list on cycle
                }
            }
        }

        // Reverse the result stack to get correct build order
        List<String> buildOrder = new ArrayList<>();
        while (!result.isEmpty()) {
            buildOrder.add(result.pop());
        }

        return buildOrder;
    }

    // Helper DFS method with cycle detection
    private static boolean dfs(
        String node,
        Map<String, List<String>> graph,
        Set<String> visited,
        Set<String> visiting,
        Stack<String> result
    ) {
        if (visiting.contains(node)) {
            // We are visiting this node again in the same DFS path → cycle
            return false;
        }

        if (visited.contains(node)) {
            // Already processed → skip
            return true;
        }

        // Start visiting this node
        visiting.add(node);

        // Visit all neighbors first (dependencies of this node)
        for (String neighbor : graph.get(node)) {
            boolean ok = dfs(neighbor, graph, visited, visiting, result);
            if (!ok) return false;  // Cycle detected deeper in graph
        }

        // Done visiting all dependencies of this node
        visiting.remove(node);     // Remove from current DFS path
        visited.add(node);         // Mark fully processed
        result.push(node);         // Add to result stack

        return true;
    }

    // Demo
    public static void main(String[] args) {
        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
            {"a", "d"},
            {"f", "b"},
            {"b", "d"},
            {"f", "a"},
            {"d", "c"}
        };

        List<String> order = findBuildOrder(projects, dependencies);
        System.out.println("Build Order: " + order);
    }
}
