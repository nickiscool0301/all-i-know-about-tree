import java.util.Deque;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapLearn {
    public void testTreeMapFeature() {
        int[] input = {8,1,5,2,6};
        TreeMap<Integer, Integer> tm = new TreeMap<>((a,b) -> b - a);
        for(int i = 0; i < input.length; i++) {
            tm.put(input[i], i);
        }
        int l = 0;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> e : tm.entrySet()) {
            int key = e.getKey();
            int value = e.getValue();

        }
    }
}
