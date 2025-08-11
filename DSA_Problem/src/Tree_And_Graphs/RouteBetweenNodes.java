package Tree_And_Graphs;

import java.util.*;

public class RouteBetweenNodes {

    public static void main(String[] args) {
        // Build a sample graph
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("D"));
        graph.put("C", new ArrayList<>());
        graph.put("D", Arrays.asList("E"));
        graph.put("E", new ArrayList<>());

        System.out.println(routeExists(graph, "A", "E")); // true
        System.out.println(routeExists(graph, "C", "E")); // false
    }

    public static boolean routeExists(Map<String, List<String>> graph, String start, String end) {
        if (start.equals(end)) return true;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            /*
            Method	What It Does
graph.get(key)	Returns value or null if not found
graph.getOrDefault(key, default)	Returns value or default if not found
             */
            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (neighbor.equals(end)) return true;

                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }
}
