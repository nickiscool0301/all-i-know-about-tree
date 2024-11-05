import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Summary of iterative
- Inorder: traverse all left -> add to stack -> pop -> add to res -> set curr to right (condition: curr no null and stack not empty)
- Pre-order: stack add root -> if stack not empty -> stack pop, set to curr -> add to res (use array list) -> add curr.right -> add curr.left to stack
reason: add right first to make sure left node is pop out first (root -> left -> right)
- Post-order: use LINKED-LIST for res since it support "Add first": stack add root -> if stack not empty -> stack pop, set to curr
-> add first to res (linked list) -> add curr.right -> add curr.left

 */


public class Main {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.left.right.right = new TreeNode(7);
    root.right.right = new TreeNode(6);
    DFS dfs = new DFS();
    System.out.println("DFS");
    System.out.println("Iterative approach");
    dfs.iterative_inorderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    dfs.iterative_preorderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    dfs.iterative_postOrderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n---------------------------");
    System.out.println("Recursive approach");
    dfs.recursive_inorderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    dfs.recursive_preorderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    dfs.recursive_postorderTraversal(root).forEach(i -> System.out.print(i + "->"));

    // BFS
    System.out.println("\n");
    System.out.println("BFS");
    BFS bfs = new BFS();
    bfs.iterative_bfs(root).forEach(i -> System.out.print(i + "->"));

    //ZigZag
    System.out.println("\n");
    test_Binary_Tree_ZigZag();

    //Shortest path graph
    System.out.println("\n");
    test_findShortestPath_Graph();
  }

  public static void test_Binary_Tree_ZigZag() {
    Binary_ZigZag_Traversal binaryZigZagTraversal = new Binary_ZigZag_Traversal();
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);
    List<List<Integer>> res = binaryZigZagTraversal.zigzagLevelOrder(root);
    res.stream().forEach(i-> System.out.print(i + ","));
   }

   public static void test_findShortestPath_Graph() {
    Map<Integer, List<Integer>> graph = new HashMap<>();
    graph.put(1, Arrays.asList(2,3));
    graph.put(2, Arrays.asList(1,4));
    graph.put(3, Arrays.asList(1,4));
    graph.put(4, Arrays.asList(2,3,5));
    graph.put(5, List.of(4));
     System.out.println("Shortest path: " + new Graph().findShortestPath(graph,1,5));
   }
}