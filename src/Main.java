import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
  }
}