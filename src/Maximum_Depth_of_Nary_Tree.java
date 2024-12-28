import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Maximum_Depth_of_Nary_Tree {
    public int DFS_maxDepth(Node root) {
        if(root == null) return 0;
        Stack<Node> s = new Stack<>();
        Stack<Integer> depth = new Stack<>();
        int max = 1;
        s.push(root);
        depth.push(1);
        while(!s.isEmpty()) {
            Node node = s.pop();
            Integer currDepth = depth.pop();
            for(Node child : node.children) {
                max = Math.max(currDepth + 1, max);
                s.push(child);
                depth.push(currDepth + 1);
            }
        }
        return max;
    }

    public int BFS_maxDepth(Node root) {
        if(root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int currDepth = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Node node = q.poll();
                for(Node child : node.children) {
                    q.offer(child);
                }
            }
            currDepth++;
        }
        return currDepth;
    }

    public int recursive_maxDepth(Node root) {
        if(root == null) return 0;
        int max = 0;
        for(Node child : root.children) {
            max = Math.max(max, 1 + recursive_maxDepth(child));
        }
        return max + 1;
    }
}

