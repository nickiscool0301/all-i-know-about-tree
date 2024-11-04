import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class DFS {
  public List<Integer> iterative_inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    TreeNode curr = root;
    while (curr != null || !s.isEmpty()) {
      while (curr != null) {
        s.add(curr);
        curr = curr.left;
      }
      curr = s.pop();
      res.add(curr.val);
      curr = curr.right;
    }
    return res;
  }

  public List<Integer> recursive_inorderTraversal(TreeNode root) {
    List<Integer> inorder_res = new ArrayList<>();
    helper_inorder(root, inorder_res);
    return inorder_res;
  }

  public List<Integer> recursive_preorderTraversal(TreeNode root) {
    List<Integer> preorder_res = new ArrayList<>();
    helper_preorder(root, preorder_res);
    return preorder_res;
  }

  public List<Integer> recursive_postorderTraversal(TreeNode root) {
    List<Integer> postorder_res = new ArrayList<>();
    helper_postorder(root, postorder_res);
    return postorder_res;
  }

  public void helper_inorder(TreeNode curr, List<Integer> res) {
    if (curr != null) {
      helper_inorder(curr.left, res);
      res.add(curr.val);
      helper_inorder(curr.right, res);
    }
  }

  public void helper_preorder(TreeNode curr, List<Integer> res) {
    if (curr != null) {
      res.add(curr.val);
      helper_preorder(curr.left, res);
      helper_preorder(curr.right, res);
    }
  }

  public void helper_postorder(TreeNode curr, List<Integer> res) {
    if (curr != null) {
      helper_postorder(curr.left, res);
      helper_postorder(curr.right, res);
      res.add(curr.val);
    }
  }

  public List<Integer> iterative_preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    if (root != null) s.push(root);
    while (!s.isEmpty()) {
      TreeNode curr = s.pop();
      res.add(curr.val);
      if (curr.right != null) {
        s.push(curr.right);
      }
      if (curr.left != null) {
        s.push(curr.left);
      }
    }
    return res;
  }


  public List<Integer> iterative_postOrderTraversal(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    Stack<TreeNode> s = new Stack<>();
    if (root != null) s.push(root);
    while (!s.isEmpty()) {
      TreeNode curr = s.pop();
      res.addFirst(curr.val);
      if (curr.left != null) {
        s.push(curr.left);
      }
      if (curr.right != null) {
        s.push(curr.right);
      }
    }
    return res;
  }
}
