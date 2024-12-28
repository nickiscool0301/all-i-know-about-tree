import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EH {
    public SpecialTreeNode buildTree(Map<String, List<String>> org, String manager) {
        List<String> empList = org.get(manager);
        SpecialTreeNode specialTreeNode = new SpecialTreeNode(manager);
        if(empList != null) {
            for(String s : empList) {
                specialTreeNode.childList.add(buildTree(org, s));
            }
        }
        return specialTreeNode;
    }

    public void printTree(SpecialTreeNode root, int level) {
        if(root == null) return;
        System.out.println("    ".repeat(level) + root.name);
        for(SpecialTreeNode e : root.childList) {
            printTree(e, level + 1);
        }
    }

    public void solve(List<String[]> input) {
        Map<String, String> orgStructure = new HashMap<>();
        for(String[] str : input) {
            orgStructure.put(str[0], str[1]);
        }
        Set<String> employeeSet = orgStructure.keySet();
        Set<String> managerSet = new HashSet<>(orgStructure.values());
        managerSet.removeAll(employeeSet);
        String leader = managerSet.iterator().next();

        Map<String, List<String>> hm = new HashMap<>();
        for(String e : orgStructure.keySet()) {
            String manager = orgStructure.get(e);
            if(!hm.containsKey(manager)) {
                hm.put(manager, new ArrayList<>());
            }
            hm.get(manager).add(e);
        }

        SpecialTreeNode root = buildTree(hm, leader);
        printTree(root, 0);
    }

    public void solve2(List<String[]> input) {
        Map<String, String> orgStructure = new HashMap<>();
        for(String[] str : input) {
            orgStructure.put(str[0], str[1]);
        }
        Set<String> employeeSet = orgStructure.keySet();
        Set<String> managerSet = new HashSet<>(orgStructure.values());

        managerSet.removeAll(employeeSet);
        String leader = managerSet.iterator().next();

        Map<String, List<String>> hm = new HashMap<>();
        for(String e : orgStructure.keySet()) {
            String manager = orgStructure.get(e);
            if(!hm.containsKey(manager)) {
                hm.put(manager, new ArrayList<>());
            }
            hm.get(manager).add(e);
        }

        buildOrg(hm, leader, 0);
    }

    private static void buildOrg(Map<String, List<String>> hm, String manager, int level) {
        System.out.println("    ".repeat(level) + manager);
        List<String> empList = hm.get(manager);
        if(empList != null) {
            for(String e : empList) {
                buildOrg(hm, e, level + 1);
            }
        }
    }
}
