package Tree_And_Graphs;

import java.util.*;

// Definition of a binary tree node for BST
class NewTreeNode {
    int val;
    NewTreeNode left;
    NewTreeNode right;

    NewTreeNode(int val) {
        this.val = val;
    }
}

public class BSTSequences {

    // Main method to return all valid sequences that can form this BST
    public static List<List<Integer>> bstSequences(NewTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        // Base case: return list containing empty list if root is null
        if (root == null) {
            result.add(new ArrayList<>());
            return result;
        }

        // Recursively get all sequences for left and right subtrees
        List<List<Integer>> leftSeqs = bstSequences(root.left);
        List<List<Integer>> rightSeqs = bstSequences(root.right);

        // For every pair of left and right sequences, weave them
        for (List<Integer> left : leftSeqs) {
            for (List<Integer> right : rightSeqs) {
                List<List<Integer>> weaved = new ArrayList<>();
                // Start weaving with root value as prefix
                weaveLists(left, right, new ArrayList<>(List.of(root.val)), weaved);
                result.addAll(weaved); // Add all weaved combinations
            }
        }

        return result;
    }

    // Helper method to weave two lists in all ways while preserving internal order
    private static void weaveLists(List<Integer> first, List<Integer> second,
                                   List<Integer> prefix, List<List<Integer>> results) {
        // Base case: if either list is empty, add the result
        if (first.isEmpty() || second.isEmpty()) {
            List<Integer> result = new ArrayList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        // Recurse with head of first added to prefix
        int headFirst = first.remove(0);
        prefix.add(headFirst);
        weaveLists(first, second, prefix, results);
        prefix.remove(prefix.size() - 1); // Backtrack
        first.add(0, headFirst);          // Restore state

        // Recurse with head of second added to prefix
        int headSecond = second.remove(0);
        prefix.add(headSecond);
        weaveLists(first, second, prefix, results);
        prefix.remove(prefix.size() - 1); // Backtrack
        second.add(0, headSecond);        // Restore state
    }

    // Main function to run and print the result
    public static void main(String[] args) {
        // Constructing the BST manually
        NewTreeNode root = new NewTreeNode(4);
        root.left = new NewTreeNode(2);
        root.right = new NewTreeNode(6);
        root.left.left = new NewTreeNode(1);
        root.left.right = new NewTreeNode(3);
        root.right.left = new NewTreeNode(5);

        // Generate all sequences
        List<List<Integer>> sequences = bstSequences(root);
        System.out.println("Possible arrays to create this BST:");
        for (List<Integer> seq : sequences) {
            System.out.println(seq); // Print each sequence
        }
    }
}
