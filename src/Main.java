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
    List<Integer> inorder_res = iterative_inorderTraversal(root);
    List<Integer> preorder_res = iterative_preorderTraversal(root);
    List<Integer> postorder_res = iterative_postOrderTraversal(root);

    System.out.println("Iterative approach");
    inorder_res.forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    preorder_res.forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    postorder_res.forEach(i -> System.out.print(i + "->"));
    System.out.println("\n---------------------------");
    System.out.println("Recursive approach");
    recursive_inorderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    recursive_preorderTraversal(root).forEach(i -> System.out.print(i + "->"));
    System.out.println("\n");
    recursive_postorderTraversal(root).forEach(i -> System.out.print(i + "->"));
  }

  public static List<Integer> iterative_inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    TreeNode curr = root;
    while(curr != null || !s.isEmpty()) {
      while(curr != null) {
        s.add(curr);
        curr = curr.left;
      }
      curr = s.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }

  public static List<Integer> recursive_inorderTraversal(TreeNode root) {
    List<Integer> inorder_res = new ArrayList<>();
    helper_inorder(root, inorder_res);
    return inorder_res;
  }

  public static List<Integer> recursive_preorderTraversal(TreeNode root) {
    List<Integer> preorder_res = new ArrayList<>();
    helper_preorder(root, preorder_res);
    return preorder_res;
  }
  public static List<Integer> recursive_postorderTraversal(TreeNode root) {
    List<Integer> postorder_res = new ArrayList<>();
    helper_postorder(root, postorder_res);
    return postorder_res;
  }

  public static void helper_inorder(TreeNode curr, List<Integer> res) {
    if(curr != null) {
      helper_inorder(curr.left, res);
      res.add(curr.val);
      helper_inorder(curr.right, res);
    }
  }

  public static void helper_preorder(TreeNode curr, List<Integer> res) {
    if(curr != null) {
      res.add(curr.val);
      helper_preorder(curr.left, res);
      helper_preorder(curr.right, res);
    }
  }

  public static void helper_postorder(TreeNode curr, List<Integer> res) {
    if(curr != null) {
      helper_postorder(curr.left, res);
      helper_postorder(curr.right, res);
      res.add(curr.val);
    }
  }

  public static List<Integer> iterative_preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    if(root != null) s.push(root);
    while(!s.isEmpty()) {
      TreeNode curr = s.pop();
      res.add(curr.val);
      if(curr.right != null) {
        s.push(curr.right);
      }
      if(curr.left != null) {
        s.push(curr.left);
      }
    }
    return res;
  }


  public static List<Integer> iterative_postOrderTraversal(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    Stack<TreeNode> s = new Stack<>();
    if(root != null) s.push(root);
    while(!s.isEmpty()) {
      TreeNode curr = s.pop();
      res.addFirst(curr.val);
      if(curr.left != null) {
        s.push(curr.left);
      }
      if(curr.right != null) {
        s.push(curr.right);
      }
    }
    return res;
  }
}