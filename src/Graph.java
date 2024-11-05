import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {
    public int findShortestPath(Map<Integer, List<Integer>> graph, int start, int end) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> distances = new HashMap<>();
        q.offer(start);
        distances.put(start,0);
        while(!q.isEmpty()) {
            int node = q.poll();
            int distance = distances.get(node);
            //If we reached the end, return dsitance
            if(node == end) return distance;
            for(int neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if(!distances.containsKey(neighbor)) {
                    q.offer(neighbor);
                    distances.put(neighbor, distance+1);
                }
            }
        }
        return -1;
    }
}
