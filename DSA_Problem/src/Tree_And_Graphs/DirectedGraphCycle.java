package Tree_And_Graphs;

import java.util.*;

public class DirectedGraphCycle {
    public static void main(String[] args) {
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B"));
        graph.put("B", Arrays.asList("C"));
        graph.put("C", Arrays.asList("A")); // cycle

        Set<String> visited = new HashSet<>();
        Set<String> recStack = new HashSet<>();

        boolean hasCycle = false;
        for (String node : graph.keySet()) {
            if (dfsCycle(graph, node, visited, recStack)) {
                hasCycle = true;
                break;
            }
        }

        System.out.println("Cycle exists? " + hasCycle);
    }

    public static boolean dfsCycle(Map<String, List<String>> graph, String node,
                                   Set<String> visited, Set<String> recStack) {
        if (recStack.contains(node)) return true;
        if (visited.contains(node)) return false;

        visited.add(node);
        recStack.add(node);

        for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
            if (dfsCycle(graph, neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack.remove(node); // backtrack
        return false;
    }
}
