import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Binary_ZigZag_Traversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return res;
        q.offer(root);
        boolean reverse = true;
        while(!q.isEmpty()) {
            List<Integer> tempList = new LinkedList<>();
            int size = q.size();
            while(size > 0) {
                size--;
                TreeNode curr = q.poll();
                if(reverse) {
                    tempList.add(curr.val);
                } else {
                    tempList.addFirst(curr.val);
                }
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            res.add(tempList);
            reverse = !reverse;
        }
        return res;
    }
}
