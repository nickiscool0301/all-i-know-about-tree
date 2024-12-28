import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
  public List<Integer> iterative_bfs(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();
    if(root == null) return res;
    q.add(root);
    while(!q.isEmpty()) {
      TreeNode curr = q.poll();
      res.add(curr.val);
      if(curr.left != null) {
        q.add(curr.left);
      }
      if(curr.right != null) {
        q.add(curr.right);
      }
    }
    return res;
  }

  // Apply BFS but for each level, only add the largest value
  public List<Integer> largestValues(TreeNode root) {
    Deque<TreeNode> dq = new ArrayDeque<>();
    List<Integer> res = new ArrayList<>();
    if(root == null) return res;
    dq.addLast(root);

    while(!dq.isEmpty()) {
      int size = dq.size();
      int max = Integer.MIN_VALUE;

      while(size-- > 0) {

        TreeNode curr = dq.poll();
        max = Math.max(max, curr.val);

        if(curr.left != null) {
          dq.addLast(curr.left);
        }

        if(curr.right != null) {
          dq.addLast(curr.right);
        }
      }
      res.add(max);
    }
    return res;
  }}
