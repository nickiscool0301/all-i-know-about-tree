import java.util.ArrayList;
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
}
